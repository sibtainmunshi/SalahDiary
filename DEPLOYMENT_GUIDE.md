# Salah Diary - Render Deployment Guide

## Quick Deploy Steps

### Option 1: GitHub + Render (Recommended)

1. **GitHub pe push karo:**
   ```bash
   git add .
   git commit -m "Ready for deployment"
   git push origin main
   ```

2. **Render pe jao:**
   - https://render.com pe jao aur sign up karo (GitHub se login karo)
   - "New +" button click karo
   - "Web Service" select karo
   - Apna GitHub repo connect karo

3. **Settings:**
   - Name: `salah-diary` (ya koi bhi naam)
   - Environment: `Node`
   - Build Command: `npm install`
   - Start Command: `npm start`
   - Plan: Free (0$)

4. **Deploy karo:**
   - "Create Web Service" button click karo
   - 2-3 minutes mein deploy ho jayega
   - Tumhe ek link milega jaise: `https://salah-diary.onrender.com`

### Option 2: Direct Deploy (Without GitHub)

1. Render Dashboard pe jao
2. "New +" > "Web Service"
3. "Public Git repository" option mein apna repo URL daalo
4. Baaki steps same as Option 1

## Important Notes

- **Free Plan:** Render ka free plan 15 minutes inactivity ke baad sleep mode mein chala jata hai. Pehli request pe 30-50 seconds lag sakte hain wake up hone mein.

- **Custom Domain:** Agar apna domain use karna hai toh Render dashboard mein "Custom Domain" section mein add kar sakte ho.

- **UI Only:** Yeh deployment sirf UI dikhayega. Native features (notifications, camera, etc.) kaam nahi karenge kyunki yeh web version hai.

## Troubleshooting

Agar koi issue aaye toh:
1. Render dashboard mein "Logs" check karo
2. Build successful hua ya nahi dekho
3. PORT environment variable automatically set hota hai, manually set karne ki zaroorat nahi

## Share Link

Deploy hone ke baad jo link milega (e.g., `https://salah-diary.onrender.com`), woh kisi ko bhi bhej sakte ho. Wo apne browser mein khol ke UI dekh sakenge - iPhone, Android, laptop kisi pe bhi!
