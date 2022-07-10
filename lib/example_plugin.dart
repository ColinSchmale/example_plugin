
import 'dart:async';

import 'package:flutter/services.dart';

class ExamplePlugin {
  static const MethodChannel _channel = MethodChannel('example_plugin');
  static const MethodChannel _channel2 = MethodChannel('example_plugin2');

  static Future<String?> get platformVersion async {
    final String? version = await _channel.invokeMethod('getPlatformVersion');
    return version;
  }

  static Future<String?> get helloWorld async {
    final String? helloWorld = await _channel2.invokeMethod('getHelloWorld');
    return helloWorld;
  }
}
