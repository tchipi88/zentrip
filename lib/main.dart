import 'package:flutter/material.dart';
import 'package:simple_splashscreen/simple_splashscreen.dart';

import 'OnBoardingPage.dart';
import 'SplashScreen.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Zentrip Application',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: MyAppWidget(),
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
      gotoWidget: OnBoardingPage(),
      splashscreenWidget: SplashScreen(),
      timerInSeconds: 5,
    );
  }
}
