import 'package:flutter/material.dart';
import 'package:zentrip/constant/Color.dart';
import 'package:zentrip/pages/account/AccountDetailPage.dart';
import 'package:zentrip/pages/sign_in/SignInPage.dart';
import 'package:zentrip/utils/SizeConfig.dart';
import 'package:zentrip/widgets/MenuItem.dart';
import 'package:zentrip/widgets/MyWidgets.dart';
import 'package:zentrip/widgets/ProfilePic.dart';

class AccountPage extends StatefulWidget {
  @override
  _AccountState createState() => _AccountState();
}

class _AccountState extends State<AccountPage> {
  @override
  Widget build(BuildContext context) {
    return Container(
        child:Scaffold(
        backgroundColor: kPrimaryColor,
        appBar: buildAppBar('Account'),
        body: Container(
          child: Container(
            decoration: buildBoxDecoration(),
            child: Body(),
          ),
        )
    )
    );
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
                      leading: Icon(Icons.account_circle, size: 50,color: kPrimaryColor,),
                      title: Text('Heart Shaker'),
                      subtitle: Text('TWICE'),
                    ),
                  ],
                ),
              )),
          MenuItem(
            text: "My Account",
            icon: "assets/icons/User Icon.svg",
            press: () {
              //Todo Navigator.pushNamed(context, SignInPage.routeName);
              Navigator.push(
                context,
                MaterialPageRoute(
                  builder: (context) => AccountDetailPage(),
                ),
              );
            },
          ),
          MenuItem(
            text: "Notifications",
            icon: "assets/icons/Bell.svg",
            press: () {},
          ),
          Card(
            child: Column(children: [
              MenuItem(
                text: "Settings",
                icon: "assets/icons/Settings.svg",
                press: () {},
              ),
              MenuItem(
                text: "Help Center",
                icon: "assets/icons/Question mark.svg",
                press: () {},
              ),
              MenuItem(
                text: "Log Out",
                icon: "assets/icons/Log out.svg",
                press: () {},
              ),
            ]),
          ),
        ],
      ),
    );
  }
}
