// We use name route
// All our routes will be available here
import 'package:flutter/material.dart';
import 'package:zentrip/pages/account/CompleteProfilePage.dart';
import 'package:zentrip/pages/account/ForgotPasswordPage.dart';
import 'package:zentrip/pages/sign_in/SignInPage.dart';
import 'package:zentrip/pages/sign_in/SignUpPage.dart';

final Map<String, WidgetBuilder> routes = {
  SignInPage.routeName: (context) => SignInPage(),
  ForgotPasswordPage.routeName: (context) => ForgotPasswordPage(),
  SignUpPage.routeName: (context) => SignUpPage(),
  CompleteProfilePage.routeName: (context) => CompleteProfilePage(),
};