let usernames = ["hormel health labss","Climate Change Is Real","Ram Abdullah","ayaz abdullah","Mahesh Kumar Rajesh"]
var googleApiKey = 'AIzaSyBYFIsOzpJLb_MS2yh1Ns1gD4WkopMFWuY';
async function printClaim(input_claim){
  //input_claim = "Those earning under £34,000 are not affected by the National Insurance (NI) rise.";
  let api_key = 'eff7d2694e124403a90b69cc6fbdd9fd';
  //let m = 'biden';
  console.log("async");
                  // Setup the Fetch GET Request with the appropriate headers and URL
                  https://idir.uta.edu/claimbuster/api/v2/query/fact_matcher/Brazil%20produces%2025%%20of%20the%20planet%E2%80%99s%20food.
  var response = await fetch((`https://idir.uta.edu/claimbuster/api/v2/query/fact_matcher/${input_claim}`), {
                      method: 'GET',
                      headers: {
                        'x-api-key': api_key,
                      }
                  });
  jso = await response.json();
  return jso;
                  // Print out the JSON payload the API sent back
  //console.log(JSON.stringify(jso, null, 2));
}

async function googleSearch(input_claim){
  input_claim = "Biden";
  let api_key = 'eff7d2694e124403a90b69cc6fbdd9fd';
  //let m = 'biden';
  //console.log("async");

  var response = await fetch('https://cors-anywhere.herokuapp.com/https://factchecktools.googleapis.com/v1alpha1/claims:search' + new URLSearchParams({
    languageCode:"en",
    maxAgeDays:256,
    offset:0,
    pageSize:25,
    query: input_claim,
    key:api_key
},{
  method:'GET',
  
}));
  jso = await response.json();
  return jso;
                  // Print out the JSON payload the API sent back
  //console.log(JSON.stringify(jso, null, 2));
}
async function getSimilarity(claimURL){
  let api_key = 'eff7d2694e124403a90b69cc6fbdd9fd';
  //let input_claim = 'biden';
  console.log("async");
                  // Setup the Fetch GET Request with the appropriate headers and URL
  let response = await fetch(claimURL, {
                      method: 'GET',
                      headers: {
                        //'x-api-key': api_key,
                      }
                  });
  return await response.json();
                  // Print out the JSON payload the API sent back;
}

var invocation = new XMLHttpRequest();
var url = 'http://172.20.10.6:5001/checktool?claim=biden';
function checkURL(){
  //if((invocation.http.readyState==4)&&(invocation.http.status==200)){
    console.log("Got request");
        invocation.open('GET', url, true);
        invocation.onreadystatechange = handler;
        invocation.send(); 
}

function handler(evtXHR){
    if (invocation.readyState == 4)
    {
            if (invocation.status == 200)
            {
                console.log(invocation.responseText);
            }
            else {
                //failure
            }
    }
}
  // async function compare(input_claim1,input_claim2){
  //                 let api_key = 'eff7d2694e124403a90b69cc6fbdd9fd';
  //                 //let input_claim = 'biden';
  //                 console.log("async");
  //                                 // Setup the Fetch GET Request with the appropriate headers and URL
  //                 let response = await fetch(`https://idir.uta.edu/claimbuster/api/v2/claim_similarity/simple_similarity/score/claim_a/${input_claim1}/claim_b/${input_claim2}`, {
  //                                     method: 'GET',
  //                                     headers: {
  //                                       'x-api-key': api_key,
  //                                     }
  //                                 });
  //                 let jso = await response.json();
  //                                 // Print out the JSON payload the API sent back
  //                                 return jso;
  // }

async function waitForElm(selector) {
  return new Promise(resolve => {
      if (document.querySelector(selector)) {
          return resolve(document.querySelector(selector));
      }

      const observer = new MutationObserver(mutations => {
          if (document.querySelector(selector)) {
              resolve(document.querySelector(selector));
              observer.disconnect();
              //console.log("Found");
          }
      });

      observer.observe(document, {
          childList: true,
          subtree: true
      });
  });
}
var v=true;
function htmlBox(i,yTot,link){
  console.log(yTot+' Creating square');
  return '<div id="alert'+i+'" style="position:fixed;'+
  'top:0;'+
  'bottom:0;'+
  'left:0;'+
  'right:0;z-index:1;top:0"><svg style="position:fixed;'+
  'top:0;'+
  'bottom:0;'+
  'left:0;'+
  'right:0;" width="100%" height="100%"><rect opacity = "0.75" style="fill : white;position:fixed;'+
  'top:0;'+
  'bottom:0;'+
  'left:0;'+
  'right:0;" width="100%" opacity = "1" height="100%"></rect><rect style="fill : black;position:fixed;" rx ="20" ry = "20" width="100%" height = "30pt" y = "' +Math.floor(yTot-25-40)+'" opacity = "0.7"> </rect><text x="150" y="' +Math.floor(yTot-40)+'" style="font-family:Chirp;"'+
  'font-size="20" fill="white" opacity="1"> This news might be misleading </text><a class="button" x="100" y="' +Math.floor(yTot-40)+'" style="font-family:Chirp;background-colour:white; cursor:pointer;" opacity="1" font-size="25" fill="silver"><text x="10" y="' +Math.floor(yTot-40)+'" style="font-family:Chirp;"'+
  'font-size="15"  fill="silver">View post</text></a>'+
  '<script src="script.js"></script><a x="200" y="' +Math.floor(yTot-40)+'" style="font-family:Chirp;background-colour:white;" opacity="1" font-size="25" fill="silver" href="'+ link +'"><text x="500" y="' +Math.floor(yTot-40)+'" style="font-family:Chirp;"'+
  'font-size="15" fill="silver">Know more</text></a></svg></div>';
}
var n;
function func(){
  console.log(JSON.stringify(oReq.json()));
}
function check(){
  return '<div id="checked"><span>checked</span></div>';}
var oldStack,a;
var ele=0;
async function displayPopup(a,i,url){
            
}
async function __displayOverlayBoard(){
    const elm = await waitForElm('[data-testid="tweet"');
    console.log('Element is ready');
    //console.log(elm.textContent);
    var a = document.querySelectorAll('[data-testid="tweet"]');
    //console.log(a.length);
      for(var i=0;i<a.length;i++){
        var postContainer = a.item(i).querySelector('[lang]');//.item(0).childNodes;//.childNodes.item(0);
        if(postContainer!=null){
          var response; 
          var str = postContainer.textContent;//.replace(/[^a-z ]/gi, '');
          var username = a.item(i).parentNode.parentNode.querySelectorAll('[role="link"]').item(1).childNodes.item(0).childNodes.item(0).textContent;
          if(usernames.includes(username)){
          function reqListener (event) {
            var a = event.target.tweetArr;
            var i = event.target.index;
            response = JSON.parse(this.responseText);
            if(a.item(i).parentNode.parentNode.querySelector('rect')==null){
              var link = response.claims[0].claimReview[0].url;
              var rating = response.claims[0].claimReview[0].textualRating.toLowerCase();
              //console.log(rating);
              
                      if(rating.length>10||rating.includes('false')||rating.includes('fake')||rating.includes('incorrect')||rating.includes('wrong')||rating.includes('misleading')){
                          var square = document.createElement('div');
                          //console.log(val);
                          square.innerHTML = htmlBox(ele,(a.item(i).parentNode.getBoundingClientRect().bottom-a.item(i).parentNode.getBoundingClientRect().top)+20,link);
                          //var button = square.  
                          a.item(i).parentNode.appendChild(square);
                          square.childNodes.item(0).childNodes.item(0).childNodes.item(3).addEventListener('click',(event)=>{
                            event.target.parentNode.parentNode.childNodes.item(0).remove();
                          });
                          ele++;
                      }
            console.log(username);
            }
            
          }
          let api_key = 'AIzaSyBYFIsOzpJLb_MS2yh1Ns1gD4WkopMFWuY';
          var oReq = new XMLHttpRequest();
          oReq.addEventListener("load", reqListener);
          oReq.tweetArr = a;
          oReq.index = i;
          oReq.open("GET",'https://factchecktools.googleapis.com/v1alpha1/claims:search?' + new URLSearchParams({
            languageCode:"en",
            maxAgeDays:256,
            offset:0,
            pageSize:25,
            query: str,
            key:api_key}));
          oReq.send();
          
          }
          else{
            function cbCheck(event){
              console.log('Check CB');        ;
              var a = event.target.tweetArr;
              var i = event.target.index;
              response = JSON.parse(this.responseText);
              console.log(response.truth);
              var rating = response.truth.toLowerCase();
              if(a.item(i).parentNode.parentNode.querySelector('rect')==null&&(rating.includes('false')||rating.includes('fake')||rating.includes('incorrect')||rating.includes('wrong')||rating.includes('misleading'))){
                var link = response.url;
                if(link=='undefined')
                link=null;
                var rating = response.truth.toLowerCase();
                //console.log(rating);
                var username = a.item(i).parentNode.parentNode.querySelectorAll('[role="link"]').item(1).childNodes.item(0).childNodes.item(0).textContent;
                        if(rating.length>10||rating.includes('false')||rating.includes('fake')||rating.includes('incorrect')||rating.includes('wrong')){
                            var square = document.createElement('div');
                            //console.log(val);
                            square.innerHTML = htmlBox(ele,(a.item(i).parentNode.getBoundingClientRect().bottom-a.item(i).parentNode.getBoundingClientRect().top)+20,link);
                            //var button = square.  
                            a.item(i).parentNode.appendChild(square);
                            square.childNodes.item(0).childNodes.item(0).childNodes.item(3).addEventListener('click',(event)=>{
                              event.target.parentNode.parentNode.childNodes.item(0).remove();
                            });
                            ele++;
                          }
                  };}
            console.log("Entered else");
            var invocation = new XMLHttpRequest();
            var url = 'https://8f81-171-76-80-155.in.ngrok.io/checktool?claim1='+ encodeURIComponent(str) ;
            //if((invocation.http.readyState==4)&&(invocation.http.status==200)){
            //console.log("Got request");
            console.log(url);
            invocation.tweetArr=a;
            invocation.index = i;
            invocation.addEventListener('load',cbCheck);
            invocation.open('GET', url, true);
            invocation.send();
        }
        }
        }
        
        }
__displayOverlayBoard();
document.addEventListener('scroll', throttle(__displayOverlayBoard,1000));
function throttle(fn, wait) {
  var time = Date.now();
  return function() {
    if ((time + wait - Date.now()) < 0) {
      fn();
      time = Date.now();
    }
  }
}
