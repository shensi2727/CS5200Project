var theTableListClickedTr;
function mouseClickTr(theTr){
		theTr.className='mouse-click-tr';
		if(theTableListClickedTr==null||theTableListClickedTr==''){
			theTableListClickedTr=theTr;	
		}else if(theTableListClickedTr!=theTr){
				theTableListClickedTr.className='';
				theTableListClickedTr=theTr;
				theTr.className='mouse-click-tr';
		}else{
				theTableListClickedTr.className='';
				theTableListClickedTr=null;
		}
}
function mouseOverTr(theTr,state){
		if(theTr.className!=null&&theTr.className!=''&&theTr.className=='mouse-click-tr'){
				return;
			}
		if(state=='over'){
			theTr.className='mouse-over-tr';	
			return;
		}
		if(state=='out'){
			theTr.className='';	
			return;
		}
		
}