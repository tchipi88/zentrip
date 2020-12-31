import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:zentrip/constant/Color.dart';
import 'package:zentrip/utils/SizeConfig.dart';
import 'package:zentrip/widgets/CategorieList.dart';

class MyHomePage extends StatefulWidget {
  @override
  _MyHomePageState createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {

  final TextEditingController _filter = new TextEditingController();

  List<String> itemList = [];

  @override
  void initState() {

    for(int count = 0; count < 50; count++)
    {
      itemList.add("Item $count");
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: NestedScrollView(
          headerSliverBuilder: (BuildContext context, bool innerBoxScrolled) {
            return <Widget>[
              createSilverAppBar()
            ];
          },
          body:  Column(
            children: [
              VerticalSpacing(),
              CategorieList(),
              VerticalSpacing(),
              CategorieList(),
            ],
          )
      ),
    );
  }

  SliverAppBar createSilverAppBar() {
    return SliverAppBar(
      title: Text('Home'),
      expandedHeight: 200,
      floating: false,
      pinned: true,
      automaticallyImplyLeading: false,
      flexibleSpace: FlexibleSpaceBar(
          titlePadding: EdgeInsets.only(bottom: 15),
          centerTitle: true,
          title: Container(
            padding: EdgeInsets.only(bottom: 2),
            constraints:
            BoxConstraints(minHeight: 40, maxHeight: 40),
            width: 220,
            child: CupertinoTextField(
              controller: _filter,
              keyboardType: TextInputType.text,
              placeholder: "Search..",
              placeholderStyle: TextStyle(
                color: Color(0xffC4C6CC),
                fontSize: 14.0,
                fontFamily: 'Brutal',
              ),
              prefix: Padding(
                padding:
                const EdgeInsets.fromLTRB(9.0, 6.0, 9.0, 6.0),
                child: Icon(Icons.search, ),
              ),
              decoration: BoxDecoration(
                borderRadius: BorderRadius.circular(8.0),
                color: Colors.white,
              ),
            ),
          ) ,
      ),
      backgroundColor: kPrimaryColor,
    );
  }


}
