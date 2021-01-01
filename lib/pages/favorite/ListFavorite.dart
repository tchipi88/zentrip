import 'package:flutter/material.dart';
import 'package:zentrip/constant/Color.dart';
import 'package:zentrip/widgets/MyWidgets.dart';

class ListFavorite extends StatefulWidget {
  @override
  _ListFavoriteState createState() => _ListFavoriteState();
}

class _ListFavoriteState extends State<ListFavorite>
    with SingleTickerProviderStateMixin {
  final List<Tab> tabs = <Tab>[
    new Tab(text: "My Posts"),
    new Tab(text: "My Search"),
  ];

  TabController _tabController;

  @override
  void initState() {
    super.initState();
    _tabController = new TabController(vsync: this, length: tabs.length);
  }

  @override
  void dispose() {
    _tabController.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        backgroundColor: kPrimaryColor,
        appBar: buildAppBar('Favoris'),
        body: Container(
            child: Container(
          height: double.infinity, // <-----
          decoration: buildBoxDecoration(),
          child: new TabBarView(
            controller: _tabController,
            children: tabs.map((Tab tab) {
              return new Center(
                  child: new Text(
                tab.text,
                style: new TextStyle(fontSize: 20.0),
              ));
            }).toList(),
          ),
        )));
  }

  AppBar buildAppBar(String title) {
    return AppBar(
      title: Text(title),
      centerTitle: true,
      elevation: 0.0,
      automaticallyImplyLeading: false,
      backgroundColor: kPrimaryColor,
      bottom: new TabBar(
        unselectedLabelColor: Colors.grey,
        labelColor: Colors.white,
        indicatorSize: TabBarIndicatorSize.label,
        tabs: tabs,
        controller: _tabController,
      ),
    );
  }
}