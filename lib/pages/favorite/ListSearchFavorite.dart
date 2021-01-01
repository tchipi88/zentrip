import 'package:flutter/material.dart';
import 'package:zentrip/constant/Color.dart';
import 'package:zentrip/widgets/MyWidgets.dart';

class ListSearchFavorite extends StatefulWidget {
  @override
  _ListSearchFavoriteState createState() => _ListSearchFavoriteState();
}

class _ListSearchFavoriteState extends State<ListSearchFavorite> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: kPrimaryColor,
      appBar: buildAppBar('ListSearchFavorite'),
      body: Center(
        child: Text('ListSearchFavorite Screen !'),
      ),
    );
  }
}