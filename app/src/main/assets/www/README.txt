FIRST LIGHT: install as a phone app
===================================

This folder is a complete installable app (a PWA). It works offline once installed.

1) Put it online (free, about 2 minutes)
   - Easiest: open https://app.netlify.com/drop and drag this whole folder onto the page.
   - Or: GitHub Pages, Vercel or Cloudflare Pages. Upload these files to the root of the site.

2) Install on your phone
   - Android: open the link in Chrome, tap the menu, then "Install app" (or "Add to Home screen").
   - iPhone: open the link in Safari, tap Share, then "Add to Home Screen".
   It then opens full screen with its own icon.

3) Optional: make an Android APK
   - Go to https://www.pwabuilder.com, paste your site link, and choose Android.
   - It gives you an APK you can install, or upload to the Play Store.

Files
   index.html            the app
   manifest.webmanifest  name, icons, colours
   sw.js                 makes it work offline and shows reminder notifications
   icon-*.png            app icons

Notes
   - Data is saved on the phone, in the app. Clearing the app's data erases it.
   - Reminders show while the app is open or running in the background.
     For a reminder that rings on a silent phone, also set a phone alarm.
