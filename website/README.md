# Salah Diary Website

Professional landing page for Salah Diary - Islamic Prayer Tracking App

## 📁 File Structure

```
website/
├── index.html          # Main HTML file
├── css/
│   └── style.css      # All styles
├── js/
│   └── script.js      # JavaScript functionality
├── images/            # Images folder (add your images here)
│   ├── app-home.png
│   ├── screenshot-home.png
│   ├── screenshot-diary.png
│   ├── screenshot-stats.png
│   ├── screenshot-qibla.png
│   └── screenshot-settings.png
└── downloads/         # APK download folder
    └── salah-diary-v1.0.apk
```

## 🖼️ Required Images

You need to add these images to the `images/` folder:

### 1. Hero Section
- **app-home.png** - Main app screenshot for hero section (300x600px recommended)

### 2. Screenshots Section
- **screenshot-home.png** - Home screen with prayer times
- **screenshot-diary.png** - Diary view with calendar
- **screenshot-stats.png** - Statistics with heatmap
- **screenshot-qibla.png** - Qibla compass
- **screenshot-settings.png** - Settings and themes

### Image Guidelines:
- Format: PNG with transparency
- Size: 1080x2340px (phone screenshots)
- Use phone mockup generators like:
  - https://mockuphone.com
  - https://smartmockups.com
  - https://www.screely.com

## 📦 APK File

Place your APK file in the `downloads/` folder:
- **salah-diary-v1.0.apk** - Your Android app APK

## 🚀 How to Use

### Option 1: Direct Open
1. Open `index.html` in any modern browser
2. That's it! The website is ready

### Option 2: Local Server (Recommended)
```bash
# Using Python
python -m http.server 8000

# Using Node.js
npx http-server

# Using PHP
php -S localhost:8000
```

Then open: `http://localhost:8000`

## 🎨 Customization

### Colors
Edit CSS variables in `style.css`:
```css
:root {
    --primary: #9333ea;        /* Main purple color */
    --primary-light: #a855f7;  /* Light purple */
    --dark-bg: #0D1117;        /* Dark background */
    --light-bg: #F3F4F6;       /* Light background */
}
```

### Content
Edit text directly in `index.html`:
- Hero section: Lines 40-70
- Features: Lines 80-200
- FAQ: Lines 350-450

### Download Link
Update APK download link in `index.html`:
```html
<a href="downloads/salah-diary-v1.0.apk" class="btn-download" download>
```

## ✨ Features

### Included:
- ✅ Fully responsive design
- ✅ Smooth scroll navigation
- ✅ Mobile menu
- ✅ FAQ accordion
- ✅ Screenshot slider
- ✅ Scroll to top button
- ✅ Animated elements on scroll
- ✅ SEO optimized
- ✅ Fast loading

### Interactive Elements:
- Mobile hamburger menu
- Smooth scroll to sections
- FAQ expand/collapse
- Screenshot carousel
- Hover effects on cards
- Scroll animations

## 📱 Responsive Breakpoints

- Desktop: 1200px+
- Tablet: 768px - 1199px
- Mobile: < 768px

## 🌐 Browser Support

- Chrome (latest)
- Firefox (latest)
- Safari (latest)
- Edge (latest)
- Mobile browsers

## 🔧 Deployment

### GitHub Pages:
1. Create a repository
2. Upload all files
3. Go to Settings > Pages
4. Select main branch
5. Your site will be live at: `username.github.io/repo-name`

### Netlify:
1. Drag and drop the `website` folder
2. Site will be live instantly
3. Get a custom domain

### Vercel:
1. Import from GitHub
2. Deploy automatically
3. Get a custom domain

## 📝 SEO Optimization

Already included:
- Meta tags for description and keywords
- Semantic HTML structure
- Alt text for images (add your own)
- Open Graph tags (add if needed)
- Fast loading time

### Add Open Graph Tags (Optional):
```html
<meta property="og:title" content="Salah Diary - Track Your Prayers">
<meta property="og:description" content="Never miss a prayer with smart notifications">
<meta property="og:image" content="images/og-image.png">
<meta property="og:url" content="https://yourdomain.com">
```

## 🎯 Performance Tips

1. **Optimize Images:**
   - Use WebP format
   - Compress with TinyPNG
   - Use appropriate sizes

2. **Minify Files:**
   ```bash
   # CSS
   npx cssnano style.css style.min.css
   
   # JavaScript
   npx terser script.js -o script.min.js
   ```

3. **Enable Caching:**
   Add `.htaccess` for Apache:
   ```apache
   <IfModule mod_expires.c>
     ExpiresActive On
     ExpiresByType image/png "access plus 1 year"
     ExpiresByType text/css "access plus 1 month"
     ExpiresByType application/javascript "access plus 1 month"
   </IfModule>
   ```

## 🐛 Troubleshooting

### Images not showing?
- Check file paths in `index.html`
- Ensure images are in `images/` folder
- Check file names match exactly (case-sensitive)

### Download not working?
- Ensure APK is in `downloads/` folder
- Check file name matches in HTML
- Try using absolute path

### Mobile menu not working?
- Check JavaScript is loaded
- Open browser console for errors
- Ensure IDs match in HTML and JS

## 📞 Support

For issues or questions:
- Check browser console for errors
- Verify all files are in correct folders
- Test in different browsers

## 📄 License

Free to use for Salah Diary project.

## 🎉 Credits

- Font: Inter (Google Fonts)
- Icons: Font Awesome
- Design: Custom modern design
- Built with: HTML, CSS, JavaScript

---

**Made with ❤️ for the Muslim Ummah**

🕌 Salah Diary - Track Your Prayers, Build Your Streak, Strengthen Your Faith