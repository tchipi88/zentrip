import 'package:flutter/material.dart';
import 'package:zentrip/model/CategorieModel.dart';
import 'package:zentrip/pages/account/AccountPage.dart';
import 'package:zentrip/pages/search/MySearch.dart';
import 'package:zentrip/utils/SizeConfig.dart';
import 'package:zentrip/widgets/CategorieList.dart';
import 'package:zentrip/widgets/SearchBox.dart';
import 'package:zentrip/widgets/bottom_navigation_bar.dart';

import 'chat/ListMessage.dart';



class HomePage extends StatefulWidget {
  @override
  _HomePageState createState() => _HomePageState();
}

class _HomePageState extends State<HomePage> {
  int _currentIndex = 0;
  List<CategorieModel> categories = <CategorieModel>[];

  @override
  void initState() {
    categories = getCategories();
  }
  @override
  Widget build(BuildContext context) {
    return Scaffold(
        bottomNavigationBar: HomePageButtonNavigationBar(
          onTap: (index) => setState(() => _currentIndex = index),
          currentIndex: _currentIndex,
        ),
        body: IndexedStack(
          index: _currentIndex,
          children: [
            Body(),
            MySearch(),
            ListMessage(),
            AccountPage()
          ],
        )
    );
  }
}

class Body extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return SingleChildScrollView(
      clipBehavior: Clip.none,
      child: SafeArea(
        top: false,
        child: Column(
          children: [
            HomeHeader(),
            VerticalSpacing(),
            CategorieList(),
            VerticalSpacing(),
            CategorieList(),
          ],
        ),
      ),
    );
  }
}

class HomeHeader extends StatelessWidget {
  const HomeHeader({
    Key key,
  }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: EdgeInsets.only(bottom: getProportionateScreenWidth(25)),
      child: Stack(
        alignment: Alignment.center,
        children: [
          Image.asset(
            "assets/images/home_bg.png",
            fit: BoxFit.cover,
            width: double.infinity,
            height: getProportionateScreenHeight(315),
          ),
          Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              SizedBox(height: getProportionateScreenHeight(80)),
              Text(
                "Travelers",
                style: TextStyle(
                    fontSize: getProportionateScreenWidth(73),
                    fontWeight: FontWeight.bold,
                    color: Colors.white,
                    height: 0.5),
              ),
              Text(
                "Travel Community App",
                style: TextStyle(color: Colors.white),
              ),
            ],
          ),
          Positioned(
            bottom: getProportionateScreenWidth(-25),
            child: SearchBox(),
          )
        ],
      ),
    );
  }
}