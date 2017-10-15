This is web application based on java to test twilio API. <br/>
To run the application you need to generate your credentials from https://www.twilio.com<br/><br/>
Twilio API allows user to integrate SMS, video, voice messaging in web and mobile apps. Here twilio is utilized to send text sms. Create a free trial account to generate API credentials. For more details visit the <a href="https://www.twilio.com/docs/"> documentation page </a></br>
To send a sms to any number, it needs to be verified from <a href="https://www.twilio.com/console/phone-numbers/verified"> Twilio </a>. Otherwise it won't send any sms for free account.</br>
Once the credentials are generated, replace the credentials in <a href="https://github.com/lakshyagupta21/amnesia/blob/master/amnesia/src/utils/Constants.java">SendMessage.java</a>
This web-app requires Java Environment to be setup on the system</br>
<ol type="number">
  <li> Install JAVA</li>
  <li> Install the Java EE version of Eclipse </li>
  <li> Setup <a href="http://tomcat.apache.org/">Tomcat</a> server
</ol>

After running tomcat server go to http://localhost:8080/amnesia/Index on the browser to run the application


