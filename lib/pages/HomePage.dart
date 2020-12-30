import 'package:flutter/material.dart';
import 'package:zentrip/pages/search/MySearch.dart';
import 'package:zentrip/pages/search/SearchPage.dart';
import 'package:zentrip/widgets/bottom_navigation_bar.dart';

import 'account/AccountPage.dart';
import 'chat/ListMessage.dart';
import 'favorite/ListFavorite.dart';



class HomePage extends StatefulWidget {
  @override
  _HomePageState createState() => _HomePageState();
}

class _HomePageState extends State<HomePage> {
  int _currentIndex = 0;

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
            MySearch(),
            ListMessage(),
            AccountPage()
          ],
        )
    );
  }
}

