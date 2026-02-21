// Service Worker for Offline Support
const CACHE_NAME = 'salahdiary-v1';
const urlsToCache = [
  '/',
  '/index.html',
  '/splash_wallpaper.jpg',
  'https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700;800&display=swap',
  'https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css'
];

// Install event - cache files
self.addEventListener('install', (event) => {
  console.log('Service Worker: Installing...');
  event.waitUntil(
    caches.open(CACHE_NAME)
      .then((cache) => {
        console.log('Service Worker: Caching files');
        return cache.addAll(urlsToCache);
      })
      .then(() => self.skipWaiting())
  );
});

// Activate event - clean old caches
self.addEventListener('activate', (event) => {
  console.log('Service Worker: Activating...');
  event.waitUntil(
    caches.keys().then((cacheNames) => {
      return Promise.all(
        cacheNames.map((cache) => {
          if (cache !== CACHE_NAME) {
            console.log('Service Worker: Clearing old cache');
            return caches.delete(cache);
          }
        })
      );
    })
  );
  return self.clients.claim();
});

// Fetch event - serve from cache, fallback to network
self.addEventListener('fetch', (event) => {
  // Skip non-GET requests
  if (event.request.method !== 'GET') return;
  
  // Skip Firebase and external API requests (always fetch fresh)
  if (event.request.url.includes('firebaseio.com') || 
      event.request.url.includes('googleapis.com') ||
      event.request.url.includes('aladhan.com')) {
    return;
  }

  event.respondWith(
    caches.match(event.request)
      .then((response) => {
        // Return cached version or fetch from network
        return response || fetch(event.request).then((fetchResponse) => {
          // Cache new requests
          return caches.open(CACHE_NAME).then((cache) => {
            cache.put(event.request, fetchResponse.clone());
            return fetchResponse;
          });
        });
      })
      .catch(() => {
        // Offline fallback
        if (event.request.destination === 'document') {
          return caches.match('/index.html');
        }
      })
  );
});

// Listen for messages from main app
self.addEventListener('message', (event) => {
  if (event.data && event.data.type === 'CACHE_PRAYER_TIMES') {
    // Cache prayer times data
    const prayerData = event.data.data;
    caches.open(CACHE_NAME).then((cache) => {
      cache.put('/prayer-times-cache', new Response(JSON.stringify(prayerData)));
      console.log('Service Worker: Prayer times cached');
    });
  }
});
