import 'package:flutter/material.dart';
import 'package:zentrip/constant/Color.dart';
import 'package:zentrip/widgets/MyWidgets.dart';

class AccountPage extends StatefulWidget {
  @override
  _AccountState createState() => _AccountState();
}
class _AccountState extends State<AccountPage> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: kPrimaryColor,
      appBar: buildAppBar('Account'),
      body: Center(
        child: Text('Account Screen !'),
      ),
    );
  }
}