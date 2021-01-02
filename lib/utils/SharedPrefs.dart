// utils/shared_prefs.dart
import 'package:shared_preferences/shared_preferences.dart';

class SharedPrefs {
  static SharedPreferences _sharedPrefs;

  init() async {
    if (_sharedPrefs == null) {
      _sharedPrefs = await SharedPreferences.getInstance();
    }
  }

  String get username => _sharedPrefs.getString(keyUsername) ?? "";

  set username(String value) {
    _sharedPrefs.setString(keyUsername, value);
  }

  bool get isfirstLaunch => _sharedPrefs.getBool(firstLaunch) ?? false;

  void setFirstLaunch(bool value) {
    _sharedPrefs.setBool(keyUsername, value);
  }
}

final sharedPrefs = SharedPrefs();
// constants/strings.dart
const String keyUsername = "key_username";
const String firstLaunch = "firstLaunch";
