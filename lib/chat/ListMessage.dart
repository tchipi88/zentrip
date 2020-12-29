import 'package:flutter/material.dart';

class ListMessage extends StatefulWidget {
  @override
  _ListMessageState createState() => _ListMessageState();
}
class _ListMessageState extends State<ListMessage> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Center(
        child: Text('ListMessage Screen !'),
      ),
    );
  }
}