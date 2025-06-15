# AFKPlugin 🎮

A lightweight and efficient Minecraft Bukkit/Spigot plugin that automatically detects when players are Away From Keyboard (AFK) and notifies other players on the server.

## ✨ Features

- **Automatic AFK Detection**: Monitors player movement and chat activity
- **Customizable Timer**: Set your own AFK timeout duration
- **Visual Indicators**: Changes player list name color when AFK
- **Server Announcements**: Broadcasts when players go AFK or return
- **Lightweight**: Minimal performance impact on your server
- **Easy Configuration**: Simple config file setup

## 📋 Requirements

- **Server Software**: Bukkit, Spigot, or Paper
- **Minecraft Version**: 1.8+ (tested on latest versions)
- **Java Version**: Java 8 or higher

## 🚀 Installation

1. Download the latest release of AFKPlugin
2. Place the `.jar` file in your server's `plugins` folder
3. Restart your server or use `/reload` (restart recommended)
4. Configure the plugin settings in `config.yml`

## ⚙️ Configuration

The plugin creates a `config.yml` file in the `plugins/AFKPlugin` folder:

```yaml
AFKtime: "90,s"  # Format: "number,unit"
                 # Units: s (seconds), m (minutes)
                 # Examples: "90,s" = 90 seconds, "5,m" = 5 minutes
```

### Configuration Examples

- `"30,s"` - Players go AFK after 30 seconds of inactivity
- `"2,m"` - Players go AFK after 2 minutes of inactivity
- `"300,s"` - Players go AFK after 5 minutes of inactivity

## 🎯 How It Works

### AFK Detection
Players are marked as AFK when they haven't performed any of these actions within the configured time:
- Moving (including looking around)
- Sending chat messages

### Visual Changes
When a player goes AFK:
- Their name in the player list (TAB) turns **black**
- A server-wide message announces they are AFK
- When they return, their name returns to normal and an announcement is made

### Automatic Return
Players automatically return from AFK status when they:
- Move their character
- Send a chat message

## 📢 Server Messages

The plugin sends these automatic messages:

- **Going AFK**: `[PlayerName] is now AFK` (Green + Gray text)
- **Returning**: `[PlayerName] is no longer AFK` (Green + Yellow text)

## 🔧 Technical Details

- **Thread Safety**: Uses asynchronous scheduling for performance
- **Memory Efficient**: Stores minimal data per player
- **Event-Driven**: Responds to player movement and chat events
- **UUID-Based**: Uses player UUIDs for reliable tracking

## 📝 Commands

This plugin currently operates automatically without commands. Future versions may include:
- `/afk` - Manually toggle AFK status
- `/afkreload` - Reload configuration

## 🐛 Troubleshooting

### Common Issues

**Players not going AFK:**
- Check your `AFKtime` configuration format
- Ensure the time value is reasonable (not too short)
- Verify the plugin loaded correctly in console

**Console Errors:**
- Make sure you're using a compatible server version
- Check that the config.yml format is correct

### Getting Help

If you encounter issues:
1. Check the server console for error messages
2. Verify your configuration syntax
3. Test with default settings first

## 📊 Performance

- **CPU Impact**: Minimal (runs every 10 seconds)
- **Memory Usage**: Very low (only stores last activity time per player)
- **Network Impact**: None (server-side only)

## 🔄 Changelog

### Version 1.0.0
- Initial release
- Basic AFK detection
- Configurable timeout
- Player list name changes
- Server announcements

## 📄 License

This plugin is provided as-is for educational and server use. Feel free to modify and distribute according to your needs.

## 🤝 Contributing

Found a bug or want to suggest a feature? Contributions are welcome! Please ensure any modifications maintain the plugin's lightweight nature and performance standards.

---

**Made with ❤️ for the Minecraft community**