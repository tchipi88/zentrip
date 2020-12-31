import 'package:flutter/material.dart';
import 'package:zentrip/constant/Color.dart';
import 'package:zentrip/utils/SizeConfig.dart';
import 'package:zentrip/widgets/MenuItem.dart';
import 'package:zentrip/widgets/MyWidgets.dart';
import 'package:zentrip/widgets/ProfilePic.dart';

class AccountDetailPage extends StatefulWidget {
  @override
  _AccountDetailState createState() => _AccountDetailState();
}
class _AccountDetailState extends State<AccountDetailPage> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: buildAppBar(),
        body: Body()
    );
  }

  AppBar buildAppBar() {
    return AppBar(
      backgroundColor: kPrimaryColor,
      automaticallyImplyLeading: true,
      leading: SizedBox(),
      // On Android it's false by default
      centerTitle: true,
      title: Text("Profile"),
      actions: <Widget>[
        FlatButton(
          onPressed: () {},
          child: Text(
            "Edit",
            style: TextStyle(
              color: Colors.white,
              fontSize: SizeConfig.defaultSize * 1.6, //16
              fontWeight: FontWeight.bold,
            ),
          ),
        ),
      ],
    );
  }
}

class Body extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return SingleChildScrollView(
      child: Column(
        children: <Widget>[
          ProfilePic(
            image: "assets/images/Profile Image.png",
            name: "Jhon Doe",
            email: "Jhondoe01@gmail.com",
          ),
          SizedBox(height: SizeConfig.defaultSize * 2), //20
          MenuItem(
            icon: "assets/icons/bookmark_fill.svg",
            text: "Saved Recipes",
            press: () {},
          ),
          MenuItem(
            icon: "assets/icons/chef_color.svg",
            text: "Super Plan",
            press: () {},
          ),
          MenuItem(
            icon: "assets/icons/language.svg",
            text: "Change Language",
            press: () {},
          ),
          MenuItem(
            icon: "assets/icons/info.svg",
            text: "Help",
            press: () {},
          ),
        ],
      ),
    );
  }
}

