Android Customized Circular Image View
===========================

1 ) Import "lib-circular-image-view" library into your workplace 

2 ) Add into your project 
    
    In the Package Explorer, right-click the dependent project and select Properties.
    In the Properties window, select the "Android" properties group at left and locate the Library properties at right.
    Click Add to open the Project Selection dialog.
    From the list of available library projects, select a project and click OK.
    When the dialog closes, click Apply in the Properties window.
    Click OK to close the Properties window.
    
3 ) 

For Xml Add following code

	<com.prashantb.lib_circular_image_view.MyImageView
	        android:layout_width="wrap_content"
	        android:layout_height="wrap_content"
	        android:layout_centerHorizontal="true"
	        android:layout_centerVertical="true"
	        android:src="@drawable/face"
	        app:stroke="10"
	        app:strokeColor="#ff0000" />

Or 

For Java File 
  In XML
  	
  	<com.prashantb.lib_circular_image_view.MyImageView
	  	android:id="@+id/iv_sample"
	        android:layout_width="wrap_content"
	        android:layout_height="wrap_content"
	        android:layout_centerHorizontal="true"
	        android:layout_centerVertical="true"
	        android:src="@drawable/face"/>
	        
  Declare following line in class:
  
         com.prashantb.lib_circular_image_view.MyImageView iv_sample;

  in Oncreate write following sentanses:
  
         iv_sample = (com.prashantb.lib_circular_image_view.MyImageView)findViewById(R.id.iv_sample);
		     iv_sample.setStroke(10);
		     iv_sample.setStrokeColor(Color.GRAY);
It Looks Like 

![](https://github.com/prashantgbhangre/android_circular-image-view/blob/master/image_smartphone.png)
