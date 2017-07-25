/**
 * Copyright 2010 The PlayN Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package playn.sample.hello.html;

import com.google.gwt.core.client.EntryPoint;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsMethod;


import playn.html.HtmlPlatform;
import playn.sample.hello.core.HelloGame;

@JsType(namespace = JsPackage.GLOBAL)
public class HelloGameHtml implements EntryPoint {

  @JsProperty
  public HelloGame helloGameMyInstance;

  @JsMethod
  public HelloGame getHelloGameMyInstanceStaticVariable() {
    return helloGameMyInstance;
  }

  public native void expose()/*-{
      $wnd.igorHelloGame = this.@playn.sample.hello.html.HelloGameHtml::helloGameMyInstance;
  }-*/;

  @Override public void onModuleLoad () {
    HtmlPlatform.Config config = new HtmlPlatform.Config();
    HtmlPlatform platform = new HtmlPlatform(config);
    platform.assets().setPathPrefix("hellogame/");
    this.helloGameMyInstance = new HelloGame(platform);
    platform.start();
    expose();
  }
}
