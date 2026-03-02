# Contributing to Salah Diary

First off, thank you for considering contributing to Salah Diary! It's people like you that make Salah Diary such a great tool for the Muslim community.

## Code of Conduct

This project and everyone participating in it is governed by respect, kindness, and the Islamic principles of good conduct. By participating, you are expected to uphold these values.

## Important: License and Copyright

This project is licensed under **CC BY-NC-ND 4.0** which means:
- You can view and learn from the code
- You can report bugs and suggest features
- You CANNOT distribute modified versions
- You CANNOT use it commercially

All contributions become part of the project under the same license.

## How Can I Contribute?

### Reporting Bugs

Before creating bug reports, please check the existing issues to avoid duplicates. When you create a bug report, include as many details as possible:

- **Use a clear and descriptive title**
- **Describe the exact steps to reproduce the problem**
- **Provide specific examples**
- **Describe the behavior you observed and what you expected**
- **Include screenshots if possible**
- **Mention your device and Android version**

### Suggesting Enhancements

Enhancement suggestions are tracked as GitHub issues. When creating an enhancement suggestion, include:

- **Use a clear and descriptive title**
- **Provide a detailed description of the suggested enhancement**
- **Explain why this enhancement would be useful**
- **List any similar features in other apps**

### Pull Requests

1. **Fork the repo** and create your branch from `main`
2. **Make your changes** following the code style guidelines
3. **Test your changes** thoroughly
4. **Update documentation** if needed
5. **Write clear commit messages**
6. **Submit a pull request**

## Development Setup

1. Clone your fork:
   ```bash
   git clone https://github.com/your-username/SalahDiary.git
   cd SalahDiary
   ```

2. Install dependencies:
   ```bash
   npm install
   ```

3. Set up Firebase:
   - Create a Firebase project
   - Add your configuration to `www/index.html`
   - Enable Authentication and Firestore

4. Run the app:
   ```bash
   npx cap sync android
   cd android
   ./gradlew assembleDebug
   ```

## Code Style Guidelines

### JavaScript
- Use meaningful variable names
- Add comments for complex logic
- Follow existing code patterns
- Keep functions small and focused
- Use ES6+ features where appropriate

### HTML/CSS
- Use semantic HTML
- Follow BEM naming convention for CSS classes
- Keep styles organized and commented
- Ensure responsive design
- Test on multiple screen sizes

### Commits
- Use present tense ("Add feature" not "Added feature")
- Use imperative mood ("Move cursor to..." not "Moves cursor to...")
- Limit first line to 72 characters
- Reference issues and pull requests

Example:
```
Add prayer streak counter feature

- Implement streak calculation logic
- Add UI components for streak display
- Update stats tab with streak card
- Add tests for streak calculation

Fixes #123
```

## Testing

Before submitting a pull request:

1. **Test on real device** - Emulators don't always catch issues
2. **Test offline mode** - Ensure offline functionality works
3. **Test different screen sizes** - Check responsive design
4. **Test prayer time calculations** - Verify accuracy
5. **Test notifications** - Ensure they work properly

## Feature Requests

We love feature requests! Before submitting:

1. **Check existing issues** - Your idea might already be there
2. **Be specific** - Describe exactly what you want
3. **Explain the use case** - Why is this feature needed?
4. **Consider Islamic guidelines** - Ensure it aligns with Islamic principles

## Priority Areas

We especially welcome contributions in these areas:

- 🐛 **Bug fixes** - Help make the app more stable
- 🌍 **Localization** - Add support for more languages
- 📱 **iOS support** - Help port the app to iOS
- ♿ **Accessibility** - Improve accessibility features
- 📚 **Documentation** - Improve docs and guides
- 🎨 **UI/UX** - Enhance user interface and experience
- ⚡ **Performance** - Optimize app performance

## Questions?

Feel free to:
- Open an issue with the "question" label
- Reach out via email
- Join our community discussions

## Recognition

Contributors will be:
- Listed in the README
- Mentioned in release notes
- Remembered in our duas 🤲

## Islamic Considerations

When contributing, please keep in mind:

- **Accuracy** - Prayer times must be accurate
- **Privacy** - User data must be protected
- **Simplicity** - Keep the app easy to use
- **Intention** - Remember this is for the sake of Allah

---

**JazakAllah Khair for contributing to Salah Diary!**

May Allah accept this work and make it beneficial for the Ummah. 🤲
