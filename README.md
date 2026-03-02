# 🕌 Salah Diary

**Never miss a prayer again.** Track your daily prayers, build consistency, and strengthen your spiritual journey with Salah Diary - a beautiful, modern prayer tracking app for Muslims.

[![License: CC BY-NC-ND 4.0](https://img.shields.io/badge/License-CC%20BY--NC--ND%204.0-lightgrey.svg)](LICENSE)
[![Platform](https://img.shields.io/badge/Platform-Android-green.svg)](https://www.android.com/)
[![Built with Capacitor](https://img.shields.io/badge/Built%20with-Capacitor-blue.svg)](https://capacitorjs.com/)

## ✨ Features

### 📿 Prayer Tracking
- **Real-time Prayer Times** - Accurate prayer times based on your location
- **Traffic Light System** - Visual indicators for prayer time windows (Green → Orange → Red)
- **Quick Status Updates** - Mark prayers as Prayed, Qaza, or Missed with a single tap
- **Offline Support** - Full functionality even without internet connection

### 📊 Analytics & Insights
- **Daily Summary** - Track your prayer completion rate
- **Streak Counter** - Build and maintain your prayer streak
- **Monthly Heatmap** - Visualize your prayer consistency over time
- **Detailed Statistics** - View your prayer performance metrics

### 🧭 Qibla Compass
- **Real-time Direction** - Find the Qibla direction anywhere in the world
- **Visual Alignment** - Color-coded compass for easy alignment
- **Accurate Calculations** - Precise Qibla direction based on your location

### 🎨 Beautiful Design
- **Modern UI** - Clean, intuitive interface with smooth animations
- **Dark/Light Theme** - Choose your preferred theme
- **Glassmorphism Effects** - Beautiful card designs with backdrop blur
- **Responsive Layout** - Optimized for all screen sizes

### 🔔 Smart Notifications
- **Prayer Reminders** - Get notified before each prayer time
- **Customizable Alerts** - Set notification preferences
- **Persistent Notifications** - Never miss a prayer reminder

### 🌍 Location-based
- **Auto-detection** - Automatically detect your location
- **Manual Search** - Search and select any city worldwide
- **Multiple Calculation Methods** - Support for Hanafi and Shafi madhabs

### 📱 Offline First
- **Cached Data** - All your data stored locally
- **Works Offline** - Full functionality without internet
- **Auto-sync** - Syncs when connection is restored

## 🚀 Getting Started

### Prerequisites
- Node.js (v14 or higher)
- Android Studio (for Android development)
- Java Development Kit (JDK 11 or higher)

### Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/yourusername/SalahDiary.git
   cd SalahDiary
   ```

2. **Install dependencies**
   ```bash
   npm install
   ```

3. **Configure Firebase**
   - Create a Firebase project at [Firebase Console](https://console.firebase.google.com/)
   - Add your Firebase configuration in `www/index.html`
   - Enable Authentication and Firestore Database

4. **Sync Capacitor**
   ```bash
   npx cap sync android
   ```

5. **Build the app**
   ```bash
   # For debug build
   cd android
   ./gradlew assembleDebug
   
   # For release build
   ./gradlew assembleRelease
   ```

### Quick Build Commands

**Windows (PowerShell):**
```powershell
# Set Java environment
$env:JAVA_HOME="C:\Program Files\Android\Android Studio\jbr"
$env:PATH="$env:JAVA_HOME\bin;$env:PATH"

# Sync and build
npx cap sync android
cd android
.\gradlew assembleRelease
```

**Or use the batch file:**
```bash
.\build-apk.bat
```

## 📁 Project Structure

```
SalahDiary/
├── www/                          # Web assets
│   ├── index.html               # Main app file
│   ├── service-worker.js        # PWA service worker
│   └── splash_wallpaper.jpg     # Splash screen image
├── android/                      # Android native project
│   ├── app/
│   │   ├── src/main/
│   │   │   ├── java/            # Java source files
│   │   │   ├── res/             # Android resources
│   │   │   └── assets/          # Web assets (auto-generated)
│   │   └── build.gradle         # App-level Gradle config
│   └── build.gradle             # Project-level Gradle config
├── website/                      # Landing page
│   ├── index.html
│   ├── css/
│   └── js/
├── capacitor.config.json        # Capacitor configuration
├── package.json                 # Node dependencies
└── README.md                    # This file
```

## 🛠️ Technologies Used

- **Frontend**: HTML5, CSS3, JavaScript (Vanilla)
- **Mobile Framework**: [Capacitor](https://capacitorjs.com/)
- **Backend**: [Firebase](https://firebase.google.com/)
  - Authentication
  - Firestore Database
  - Cloud Storage
- **APIs**:
  - [Aladhan Prayer Times API](https://aladhan.com/prayer-times-api)
  - Geolocation API
  - Notifications API
- **Charts**: [Chart.js](https://www.chartjs.org/)
- **Icons**: [Font Awesome](https://fontawesome.com/)

## 🎯 Key Features Explained

### Traffic Light System
The app uses a color-coded system to indicate prayer time windows:
- 🟢 **Green**: Optimal time to pray (beginning of prayer window)
- 🟠 **Orange**: Prayer time is passing (middle of window)
- 🔴 **Red**: Prayer time ending soon (last portion of window)

### Madhab Support
- **Hanafi**: Uses Hanafi calculation method for Asr prayer
- **Shafi**: Uses standard calculation method for Asr prayer

### Offline Authentication
The app implements a robust offline authentication system:
- Caches user data locally
- Works completely offline after initial login
- Auto-syncs when connection is restored
- Never shows login screen if cached auth is valid

## 📱 Screenshots

*Coming soon - Add screenshots of your app here*

## 🔐 Security & Privacy

- **Local Storage**: All prayer data stored locally on device
- **Firebase Auth**: Secure authentication with email/password
- **No Tracking**: We don't track or sell your data
- **Offline First**: Your data stays on your device

## 🤝 Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

1. Fork the project
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📝 License

This project is licensed under the **Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International License**.

**What this means:**
- ✅ You can use the app for free
- ✅ You can share it with others
- ✅ You can view and learn from the code
- ❌ You cannot sell it or use it commercially
- ❌ You cannot modify and distribute it
- ❌ You must give credit to the original author

See the [LICENSE](LICENSE) file for full details.

For commercial use or modifications, please contact the author.

## 🙏 Acknowledgments

- [Aladhan API](https://aladhan.com/) for prayer times calculations
- [Font Awesome](https://fontawesome.com/) for beautiful icons
- [Chart.js](https://www.chartjs.org/) for data visualization
- The Muslim developer community for inspiration

## 📧 Contact

For questions, suggestions, or support:
- Email: your.email@example.com
- GitHub Issues: [Create an issue](https://github.com/yourusername/SalahDiary/issues)

## 🌟 Support the Project

If you find this app helpful, please consider:
- ⭐ Starring the repository
- 🐛 Reporting bugs
- 💡 Suggesting new features
- 🤲 Making dua for the developers

---

**Made with ❤️ for the Muslim Ummah**

*"Indeed, prayer has been decreed upon the believers a decree of specified times." - Quran 4:103*
