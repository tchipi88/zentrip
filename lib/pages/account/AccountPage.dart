import 'package:flutter/material.dart';
import 'package:zentrip/constant/Color.dart';
import 'package:zentrip/widgets/MenuItem.dart';
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
        body: Container(
          child: Container(
            height: double.infinity, // <-----
            decoration: buildBoxDecoration(),
            child: Body(),
          ),
        ));
  }
}

class Body extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return SingleChildScrollView(
      child: Column(
        children: [
          Padding(
              padding: EdgeInsets.symmetric(horizontal: 20, vertical: 10),
              child: Card(
                shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(15)),
                child: Column(
                  mainAxisSize: MainAxisSize.min,
                  children: <Widget>[
                    const ListTile(
                      leading: Icon(
                        Icons.account_circle,
                        size: 60,
                        color: kPrimaryColor,
                      ),
                      title: Text('Heart Shaker'),
                      subtitle: Text('TWICE'),
                      trailing:
                          Icon(Icons.arrow_forward_ios, color: kPrimaryColor),
                    ),
                  ],
                ),
              )),
          MenuItem(
            text: "Notifications",
            icon: "assets/icons/Bell.svg",
            press: () {},
          ),
          Card(
            child: Column(children: [
              MenuItem(
                text: "About Us",
                icon: "assets/icons/Settings.svg",
                press: () {},
              ),
              MenuItem(
                text: "Terms of Services",
                icon: "assets/icons/Question mark.svg",
                press: () {},
              ),
              MenuItem(
                text: "Privacy Policy",
                icon: "assets/icons/Question mark.svg",
                press: () {},
              ),
              MenuItem(
                text: "Licences",
                icon: "assets/icons/Question mark.svg",
                press: () {},
              ),
            ]),
          ),
          Card(
            child: Column(children: [
              MenuItem(
                text: "Send FeedBack",
                icon: "assets/icons/Settings.svg",
                press: () {},
              ),
              MenuItem(
                text: "Share App",
                icon: "assets/icons/Question mark.svg",
                press: () {},
              ),
            ]),
          ),
        ],
      ),
    );
  }
}
