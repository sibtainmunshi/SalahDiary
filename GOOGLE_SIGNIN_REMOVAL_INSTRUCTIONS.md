# Google Sign-In Removal Instructions

## What to Remove:

### 1. HTML Elements (in auth-screen):
- Google Sign-In button in signup form (id="google-signup-btn")
- Google Sign-In button in login form (id="google-login-btn")
- "OR" dividers after Google buttons
- Google SVG icons

### 2. JavaScript Code:
- `handleGoogleSignIn()` function
- Google button event listeners
- Google Auth imports from Firebase
- Google sign-in method check in "Continue As" logic

### 3. CSS:
- `.btn-google` styles
- `.btn-google:hover` styles
- Light theme Google button styles

---

## Simplified Auth Screen (Email/Password Only):

**Signup Form:**
- Email input
- Password input
- Confirm Password input
- "Already have an account? Log In" link

**Login Form:**
- Email input
- Password input
- "Don't have an account? Sign Up" link

---

## Benefits:
- ✅ Simpler authentication flow
- ✅ No Google Cloud Console dependency
- ✅ No Error Code 10 issues
- ✅ Faster onboarding
- ✅ Less code to maintain

---

Bhai, yeh bahut saara code remove karna padega. Kya main ek clean version bana du with only email/password auth?
