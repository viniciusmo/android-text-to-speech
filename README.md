android-text-to-speech
====================================

Enables using Google Translate from a Android application

Download last version here  [android-text-to-speech](https://github.com/viniciusmo/android-text-to-speech/blob/master/android-text-to-speech/target/android-text-to-speech.jar?raw=true) 
=============

Translating a Text
=============	
    String expected = "chair";
    String actual = Translator.translate(Language.PORTUGUESE_BR,
    Language.ENGLISH, "cadeira");

Speaking a Text
=============	
    Context context = this;
    OnCompleteLoad onCompleteLoad = new OnCompleteLoad() {
    
    		@Override
	    	public void onCompleteLoaded() {
    			System.out.println("Finish speack");
    		}
    };
    Speaker.speack(textForSpeech, Language.PORTUGUESE_BR, context,onCompleteLoad);

## License

(The MIT License)

Copyright (c) 2013 Vinicius Oliveira

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
