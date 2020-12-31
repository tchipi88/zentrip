import 'package:flutter/material.dart';
import 'package:zentrip/constant/Color.dart';
import 'package:zentrip/widgets/MyWidgets.dart';

class ListSearch extends StatefulWidget {
  @override
  _ListSearchState createState() => _ListSearchState();
}
class _ListSearchState extends State<ListSearch> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: kPrimaryColor,
      appBar: buildAppBar('ListSearch'),
      body: Center(
        child: Text('ListSearch Screen !'),
      ),
    );
  }
}