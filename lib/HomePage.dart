import 'package:curved_navigation_bar/curved_navigation_bar.dart';
import 'package:flutter/material.dart';
import 'package:zentrip/account/SettingsPage.dart';
import 'package:zentrip/chat/ListMessage.dart';
import 'package:zentrip/favorite/ListFavorite.dart';
import 'package:zentrip/post/AddPost.dart';
import 'package:zentrip/search/SearchPage.dart';


class HomePage extends StatefulWidget {
  @override
  _HomePageState createState() => _HomePageState();
}

class _HomePageState extends State<HomePage> {
  int _page = 0;
  GlobalKey _bottomNavigationKey = GlobalKey();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        bottomNavigationBar: CurvedNavigationBar(
          key: _bottomNavigationKey,
          index: 0,
          height: 50.0,
          items: <Widget>[
            Icon(Icons.search, size: 30),
            Icon(Icons.favorite_border, size: 30),
            Icon(Icons.add_box_outlined, size: 30),
            Icon(Icons.message_outlined, size: 30),
            Icon(Icons.perm_identity, size: 30),
          ],
          color: Colors.white,
          buttonBackgroundColor: Colors.white,
          backgroundColor: Colors.blueAccent,
          animationCurve: Curves.easeInOut,
          animationDuration: Duration(milliseconds: 600),
          onTap: (index) {
            setState(() {
              _page = index;
            });
          },
          letIndexChange: (index) => true,
        ),
        body: IndexedStack(
          index: _page,
          children: [
            SearchPage(),
            ListFavorite(),
            AddPost(),
            ListMessage(),
            SettingsPage()
          ],
        )
    );
  }
}

