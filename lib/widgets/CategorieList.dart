import 'package:flutter/material.dart';
import 'package:zentrip/constant/TextStyle.dart';
import 'package:zentrip/model/CategorieModel.dart';
import 'package:zentrip/utils/SizeConfig.dart';
import 'package:zentrip/widgets/SectionTitle.dart';

import 'MyWidgets.dart';

class CategorieList extends StatelessWidget {
  const CategorieList({
    Key key,
  }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Column(
      children: [
        SectionTitle(
          title: "Top Categories",
          press: () {},
        ),
        VerticalSpacing(of: 20),
        SingleChildScrollView(
          clipBehavior: Clip.none,
          scrollDirection: Axis.horizontal,
          child: Row(
            children: [
              ...List.generate(
                getCategories().length,
                    (index) => Padding(
                  padding: EdgeInsets.only(
                      left: getProportionateScreenWidth(kDefaultPadding)),
                  child: CategoryCard(
                    imageAssetUrl: getCategories()[index].imageAssetUrl,
                    categoryName: getCategories()[index].categorieName,
                  ),
                ),
              ),
              SizedBox(
                width: getProportionateScreenWidth(kDefaultPadding),
              ),
            ],
          ),
        ),
      ],
    );
  }
}