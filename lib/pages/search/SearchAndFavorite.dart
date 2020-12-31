import 'package:flutter/material.dart';
import 'package:zentrip/constant/Color.dart';
import 'package:zentrip/pages/favorite/ListFavorite.dart';
import 'package:zentrip/pages/search/ListSearch.dart';
import 'package:zentrip/widgets/CategorySelector.dart';
import 'package:zentrip/widgets/MyWidgets.dart';

class SearchAndFavorite extends StatefulWidget {
  @override
  _SearchAndFavoriteState createState() => _SearchAndFavoriteState();
}

class _SearchAndFavoriteState extends State<SearchAndFavorite> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: kPrimaryColor,
      appBar:buildAppBar('Favoris'),
      body: Column(
        children: <Widget>[
          Expanded(
            child: Container(
              decoration: buildBoxDecoration(),

            ),
          ),
        ],
      ),
    );
  }
}