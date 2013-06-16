android-text-to-speech
====================================

Enables using Google Translate from a Android application

Download here  [android-text-to-speech](https://github.com/viniciusmo/android-text-to-speech/blob/master/android-text-to-speech/target/android-text-to-speech-1.0.0.jar?raw=true) 
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

