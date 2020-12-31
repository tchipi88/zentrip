//Splash Screen
import 'package:flutter/material.dart';
import 'package:zentrip/utils/SizeConfig.dart';

class SplashScreen extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    // You have to call it on your starting screen
    SizeConfig().init(context);
    return Scaffold(
      body: Center(
        child: Image.asset('assets/images/img1.jpg', width: 350.0),
      ),
    );
  }
}
