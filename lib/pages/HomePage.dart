import 'package:flutter/material.dart';
import 'package:zentrip/model/CategorieModel.dart';
import 'package:zentrip/pages/account/AccountPage.dart';
import 'package:zentrip/pages/favorite/ListFavorite.dart';
import 'package:zentrip/pages/search/SearchPage.dart';
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
            SearchPage(),
            ListFavorite(),
            ListMessage(),
            AccountPage()
          ],
        )
    );
  }
}

