import 'package:flutter/material.dart';
import 'package:google_fonts/google_fonts.dart';
import 'package:simple_splashscreen/simple_splashscreen.dart';
import 'package:zentrip/pages/HomePage.dart';
import 'package:zentrip/routes.dart';
import 'package:zentrip/utils/SharedPrefs.dart';

import 'constant/Color.dart';
import 'pages/OnBoardingPage.dart';
import 'pages/SplashScreen.dart';

Future<void> main() async {
  WidgetsFlutterBinding.ensureInitialized();
  await sharedPrefs.init();
  runApp(
    MyApp(),
  );
}

class MyApp extends StatelessWidget {
  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Zentrip Application',
      theme: ThemeData(
        textTheme: GoogleFonts.poppinsTextTheme(Theme.of(context).textTheme),
        primaryColor: kPrimaryColor,
        accentColor: kAccentColor,
        scaffoldBackgroundColor: Colors.white,
        visualDensity: VisualDensity.adaptivePlatformDensity,
        appBarTheme: AppBarTheme(color: Colors.white, elevation: 0),
        fontFamily: 'Ubuntu',
      ),
      home: MyAppWidget(),
      routes:routes,
    );
  }
}

class MyAppWidget extends StatefulWidget {
  @override
  _MyAppState createState() => _MyAppState();
}
class _MyAppState extends State<MyAppWidget> {
  @override
  Widget build(BuildContext context) {
    return Simple_splashscreen(
      context: context,
      gotoWidget: sharedPrefs.isfirstLaunch ? OnBoardingPage() : HomePage(),
      splashscreenWidget: SplashScreen(),
      timerInSeconds: 5,
    );
  }
}
