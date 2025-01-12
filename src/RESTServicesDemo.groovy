
println '''
                     _                      
 _ __ ___   __ _ ___| |__   __ _ _ __   ___ 
| '_ ` _ \\ / _` / __| '_ \\ / _` | '_ \\ / _ \\
| | | | | | (_| \\__ \\ | | | (_| | |_) |  __/
|_| |_| |_|\\__,_|___/_| |_|\\__,_| .__/ \\___|
                                |_|         
'''
@Grab('com.mashape.unirest:unirest-java:1.4.9')

import com.mashape.unirest.http.Unirest

def response_mashape = Unirest.get("https://dennikn.sk/svet")
        .asString()

println "Status Code: ${response_mashape.status}"
println "Response Body: ${response_mashape.body}"
println '''
       _    _     _   _         
  ___ | | _| |__ | |_| |_ _ __  
 / _ \\| |/ / '_ \\| __| __| '_ \\ 
| (_) |   <| | | | |_| |_| |_) |
 \\___/|_|\\_\\_| |_|\\__|\\__| .__/ 
                         |_|             
'''

@Grab('com.squareup.okhttp3:okhttp:4.9.1')

import okhttp3.OkHttpClient
import okhttp3.Request

def client_okhttp = new OkHttpClient()
def request = new Request.Builder()
        .url('https://example.com')
        .build()

def response_okhttp = client_okhttp.newCall(request).execute()

println "Status Code: ${response_okhttp.code()}"
println "Response Body: ${response_okhttp.body().string()}"

println '''
                        _          
  __ _ _ __   __ _  ___| |__   ___ 
 / _` | '_ \\ / _` |/ __| '_ \\ / _ \\
| (_| | |_) | (_| | (__| | | |  __/
 \\__,_| .__/ \\__,_|\\___|_| |_|\\___|
      |_|                          
'''
@Grab('org.apache.httpcomponents:httpclient:4.5.13')

import org.apache.http.client.methods.HttpGet
import org.apache.http.impl.client.HttpClients
import org.apache.http.util.EntityUtils

def client_apache = HttpClients.createDefault()
def get = new HttpGet('https://example.com')
def response_appache = client_apache.execute(get)

println "Status Code: ${response_appache.getStatusLine().getStatusCode()}"
def entity = response_appache.getEntity()
println "Response Body: ${EntityUtils.toString(entity)}"
EntityUtils.consume(entity)

println '''
   _                  
  (_) __ ___   ____ _ 
  | |/ _` \\ \\ / / _` |
  | | (_| |\\ V / (_| |
 _/ |\\__,_| \\_/ \\__,_|
|__/                  
'''

import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

def client_java = HttpClient.newHttpClient()
def request_java = HttpRequest.newBuilder()
        .uri(URI.create('https://example.com'))
        .GET()
        .build()
def response_java = client_java.send(request_java, HttpResponse.BodyHandlers.ofString())

println "Status Code: ${response_java.statusCode()}"
println "Response Body: ${response_java.body()}"