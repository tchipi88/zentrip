import 'package:flutter/material.dart';

class HomePageButtonNavigationBar extends StatelessWidget {
  final Function(int) onTap;
  final int currentIndex;
  HomePageButtonNavigationBar({@required this.currentIndex, @required this.onTap});
  @override
  Widget build(BuildContext context) {
    return BottomNavigationBar(
      onTap: onTap,
      currentIndex: currentIndex,
      selectedItemColor: Theme.of(context).primaryColor,
      type: BottomNavigationBarType.fixed,
      items: [
          BottomNavigationBarItem(icon: Icon(Icons.search),          label: 'Search'),
          BottomNavigationBarItem(icon: Icon(Icons.notifications_none_outlined), label: 'My Search'),
          BottomNavigationBarItem(icon: Icon(Icons.message_outlined),label: 'Messages'),
          BottomNavigationBarItem(icon: Icon(Icons.account_circle_outlined),   label: 'Account'),
      ],
    );
  }
}
