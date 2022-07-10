import Flutter
import UIKit

public class SwiftExamplePlugin: NSObject, FlutterPlugin {
  public static func register(with registrar: FlutterPluginRegistrar) {
    let channel = FlutterMethodChannel(name: "example_plugin", binaryMessenger: registrar.messenger())
    let channel2 = FlutterMethodChannel(name: "example_plugin2", binaryMessenger: registrar.messenger())
    
    channel.setMethodCallHandler(firstMethodCallHandler)
    channel2.setMethodCallHandler(secondMethodCallHandler)
  }

  static public func firstMethodCallHandler(_ call: FlutterMethodCall, result: @escaping FlutterResult) {
    result("iOS " + UIDevice.current.systemVersion)
  }
    
  static public func secondMethodCallHandler(_ call: FlutterMethodCall, result: @escaping FlutterResult) {
    result("Hello World!")
  }
}
