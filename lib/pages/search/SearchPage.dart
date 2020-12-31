import 'package:flutter/material.dart';
import 'package:zentrip/constant/TextStyle.dart';
import 'package:zentrip/model/CategorieModel.dart';
import 'package:zentrip/utils/app_utils.dart';
import 'package:zentrip/widgets/MyWidgets.dart';
import 'package:zentrip/widgets/SearchBox.dart';
import 'package:zentrip/widgets/UIHelper.dart';
import 'package:zentrip/widgets/home_bg_color.dart';

class SearchPage extends StatefulWidget {
  @override
  _SearchPageState createState() => _SearchPageState();
}

class _SearchPageState extends State<SearchPage> with TickerProviderStateMixin {
  bool _loading;
  List<CategorieModel> categories = <CategorieModel>[];

  ScrollController scrollController;
  AnimationController controller;
  AnimationController opacityController;
  Animation<double> opacity;

  @override
  void initState() {
    scrollController = ScrollController();
    controller =  AnimationController(vsync: this, duration: Duration(seconds: 1))..forward();
    opacityController = AnimationController(vsync: this, duration: Duration(microseconds: 1));
    opacity = Tween(begin: 1.0, end: 0.0).animate(CurvedAnimation(
      curve: Curves.linear,
      parent: opacityController,
    ));
    scrollController.addListener(() {
      opacityController.value = offsetToOpacity(
          currentOffset: scrollController.offset,
          maxOffset: scrollController.position.maxScrollExtent / 2);
    });

    _loading = true;
    super.initState();
    categories = getCategories();
    _loading = false;
  }

  @override
  void dispose() {
    controller.dispose();
    scrollController.dispose();
    opacityController.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
    appBar: buildAppBar('Home'),
    body: Stack(
    children: <Widget>[
            HomeBackgroundColor(opacity),
            SingleChildScrollView(
              controller: scrollController,
              padding: EdgeInsets.only(top: 100),
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: <Widget>[
                  SearchBox(),
                  UIHelper.verticalSpace(16),
                  buildCategorieList(),
                  UIHelper.verticalSpace(16),
                  buildNewPosts(),
                ],
    ),
    ),
    ],
    )
    );
  }
Widget buildCategorieList(){
return  /// Categories
  Container(
    padding: EdgeInsets.symmetric(horizontal: 16),
    height: 70,
    child: ListView.builder(
        scrollDirection: Axis.horizontal,
        itemCount: categories.length,
        itemBuilder: (context, index) {
          return CategoryCard(
            imageAssetUrl: categories[index].imageAssetUrl,
            categoryName: categories[index].categorieName,
          );
        }),
  );
}


Widget buildNewPosts() {
    return Container(
      decoration: BoxDecoration(
        borderRadius: BorderRadius.vertical(top: Radius.circular(16)),
        color: Colors.white,
      ),
      padding: const EdgeInsets.all(16),
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: <Widget>[
          Row(
            mainAxisAlignment: MainAxisAlignment.start,
            children: <Widget>[
              Text("New Posts", style: headerStyle),
              Spacer(),
              Icon(Icons.more_horiz),
              UIHelper.horizontalSpace(16),
            ],
          )
        ],
      ),
    );
  }

}
