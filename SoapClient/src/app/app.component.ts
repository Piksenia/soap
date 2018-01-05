import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app';
  ergebnis:any;

  constructor(){
    this.getHello();
  }

  getHello(){
    let xmlhttp = new XMLHttpRequest();
    xmlhttp.open("POST","http://localhost:8080/BmiRechner/bmi?wsdl=", false );
    xmlhttp.setRequestHeader("Content-Type","text/xml" );
    xmlhttp.send("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:hs=\"http://ws.com/\">\r\n <soapenv:Header/>\r\n <soapenv:Body>\r\n <hs:getBmi>\r\n\t<gewicht>80.0</gewicht>\r\n\t<groesse>1.7</groesse>\r\n </hs:getBmi>\r\n </soapenv:Body>\r\n</soapenv:Envelope>");
    //console.log(xmlhttp.responseXML);
    console.log(xmlhttp.responseXML.getElementsByTagName("return")[0].childNodes[0].nodeValue);
    this.ergebnis = xmlhttp.responseXML.getElementsByTagName("return")[0].childNodes[0].nodeValue
    //document.write("Dein BMI beträgt " +ergebnis);

  }
}
