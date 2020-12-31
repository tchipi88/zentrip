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
    return Scaffold(
      appBar: buildAppBar(),
      body: Body()
    );
  }
}

AppBar buildAppBar() {
  return AppBar(
    backgroundColor: kPrimaryColor,
    leading: SizedBox(),
    // On Android it's false by default
    centerTitle: true,
    title: Text("Account"),

  );
}


class Body extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return SingleChildScrollView(
      child: Column(
        children: [
          ProfilePic(
            image: "assets/images/Profile Image.png",
            name: "Jhon Doe",
            email: "Jhondoe01@gmail.com",
          ),
          SizedBox(height: SizeConfig.defaultSize * 2), //20
          MenuItem(
            text: "My Account",
            icon: "assets/icons/User Icon.svg",
            press: ()  {
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
        ],
      ),
    );
  }
}
