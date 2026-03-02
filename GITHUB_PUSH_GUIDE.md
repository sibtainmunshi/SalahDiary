# GitHub Push Guide for Salah Diary

## Step-by-Step Instructions

### 1. Create GitHub Repository

1. Go to [GitHub](https://github.com)
2. Click on "+" icon → "New repository"
3. Repository name: `SalahDiary`
4. Description: "A beautiful prayer tracking app for Muslims"
5. Choose: **Public** (or Private if you prefer)
6. **DO NOT** initialize with README (we already have one)
7. Click "Create repository"

### 2. Prepare Local Repository

Run these commands in PowerShell:

```powershell
# Navigate to project directory
cd C:\Users\Sibtainhaidar\Desktop\SalahDiary

# Add all files
git add .

# Commit with message
git commit -m "Initial commit: Complete Salah Diary app with offline support

Features:
- Prayer time tracking with traffic light system
- Offline authentication and data persistence
- Qibla compass with real-time direction
- Daily diary and monthly statistics
- Smart notifications for prayer reminders
- Dark/Light theme support
- Beautiful glassmorphism UI
- Complete offline functionality

Tech Stack:
- Capacitor for mobile development
- Firebase for authentication and database
- Vanilla JavaScript for performance
- Chart.js for data visualization"
```

### 3. Connect to GitHub

Replace `YOUR_GITHUB_USERNAME` with your actual GitHub username:

```powershell
# Add remote repository
git remote add origin https://github.com/YOUR_GITHUB_USERNAME/SalahDiary.git

# Verify remote
git remote -v

# Push to GitHub
git push -u origin main
```

If you get an error about branch name, try:
```powershell
git branch -M main
git push -u origin main
```

### 4. Verify Upload

1. Go to your GitHub repository
2. Refresh the page
3. You should see all files uploaded
4. Check that README.md displays properly

## Important Notes

### Files NOT Pushed (in .gitignore)
- `node_modules/` - Dependencies (users will run `npm install`)
- `android/key.properties` - Your signing keys (KEEP PRIVATE!)
- `*.keystore` - Keystore files (KEEP PRIVATE!)
- `android/build/` - Build artifacts
- `.env` files - Environment variables

### Sensitive Files
**NEVER push these files:**
- `android/key.properties` - Contains keystore passwords
- `android/my-release-key.keystore` - Your app signing key
- Any file with API keys or passwords

### Firebase Configuration
The Firebase config in `www/index.html` is okay to push if:
- You're using Firebase security rules
- Your API key is restricted in Firebase Console
- You're not exposing any sensitive data

To be extra safe, you can:
1. Create a `.env` file for Firebase config
2. Use environment variables
3. Add `.env` to `.gitignore`

## After Pushing

### Update README
1. Replace `yourusername` with your GitHub username in README.md
2. Add your email in the Contact section
3. Add screenshots to the repository
4. Update the repository URL

### Add Topics (Tags)
On GitHub repository page:
1. Click "Add topics"
2. Add: `prayer`, `islam`, `muslim`, `android`, `capacitor`, `firebase`, `prayer-times`, `salah`, `namaz`

### Create Releases
1. Go to "Releases" → "Create a new release"
2. Tag: `v1.0.0`
3. Title: "Salah Diary v1.0.0 - Initial Release"
4. Upload the APK file: `android/app/build/outputs/apk/release/app-release.apk`
5. Write release notes

### Enable GitHub Pages (for website)
1. Go to Settings → Pages
2. Source: Deploy from branch
3. Branch: `main`, folder: `/website`
4. Save
5. Your website will be live at: `https://yourusername.github.io/SalahDiary/`

## Troubleshooting

### Authentication Error
If you get authentication error:
```powershell
# Use GitHub CLI
gh auth login

# Or use Personal Access Token
# Go to GitHub → Settings → Developer settings → Personal access tokens
# Generate new token with 'repo' scope
# Use token as password when pushing
```

### Large File Error
If you get "file too large" error:
```powershell
# Check file sizes
git ls-files -z | xargs -0 du -h | sort -h

# Remove large files from git
git rm --cached path/to/large/file
git commit -m "Remove large file"
```

### Branch Name Issue
If main branch doesn't exist:
```powershell
git branch -M main
git push -u origin main
```

## Next Steps

After pushing to GitHub:

1. ✅ Add repository description and topics
2. ✅ Upload screenshots to repository
3. ✅ Create first release with APK
4. ✅ Enable GitHub Pages for website
5. ✅ Add repository link to your profile
6. ✅ Share with the community!

## Useful Git Commands

```powershell
# Check status
git status

# View commit history
git log --oneline

# Create new branch
git checkout -b feature-name

# Push changes
git add .
git commit -m "Your message"
git push

# Pull latest changes
git pull origin main

# View remote URL
git remote -v
```

---

**Ready to push? Follow the steps above and your app will be on GitHub! 🚀**
