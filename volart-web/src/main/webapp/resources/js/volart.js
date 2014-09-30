var MARGIN_TOP = 5;
var MARGE_CURSOR = 10;
var CANVAS_HEIGHT = 30;
var GAUGE_HEIGHT = 10;
var GAUGE_COLOR = "#BDBDBD"
var GAUGE_BORDER_COLOR = "black";
var LABEL_COLOR = "black";
var LABEL_FONT = "14px Arial";
var LIMIT_MIN_CURSOR_COLOR = "black";
var LIMIT_MAX_CURSOR_COLOR = "red";
var POSITION_CURSOR_COLOR = "#01DF01";
var CURSOR_WIDTH = 5;

function drawGauge(aParentId, aCanvasId, varMin, varMax, varVal) {
	//console.log( "Draw!" );
	
	var parentWidth;
	
	// Redimensionner le canvas	
	var parent = $("#"+aParentId);
	parentWidth = parent.width();
	var canv = $("#"+aCanvasId);
	canv.attr( 'width', parentWidth );
	canv.attr( 'height', CANVAS_HEIGHT );
	
	var c = document.getElementById(aCanvasId);
	var ctx = c.getContext("2d");
	ctx.beginPath();
	
	// -----------------------------------------
	// Gauge
	// -----------------------------------------
	drawSimpleGauge(ctx, parentWidth);
	
	
	
	if(varVal < varMin){
		// -----------------------------------------
		// Limite min
		// -----------------------------------------	
		var posLimitMin = getPosition(parentWidth, varVal, varMax, varMin);
		drawCursor(ctx, posLimitMin, varMin, LIMIT_MIN_CURSOR_COLOR);
		
		// -----------------------------------------
		// Limite max
		// -----------------------------------------
		var posLimitMax = (parentWidth / 100) * (100 - MARGE_CURSOR);
		drawCursor(ctx, posLimitMax, varMax, LIMIT_MAX_CURSOR_COLOR);
		
		// -----------------------------------------
		// Var position
		// -----------------------------------------		
		var posVarVal = (parentWidth / 100) * MARGE_CURSOR;
		drawCursor(ctx, posVarVal, varVal, POSITION_CURSOR_COLOR, 'POSITION');
	
		
	
	}else if (varVal > varMax) {
		// -----------------------------------------
		// Limite min
		// -----------------------------------------
		var posLimitMin = (parentWidth / 100) * MARGE_CURSOR;
		drawCursor(ctx, posLimitMin, varMin, LIMIT_MIN_CURSOR_COLOR);
		
		// -----------------------------------------
		// Limite max
		// -----------------------------------------
		var posLimitMax = getPosition(parentWidth, varMin, varVal, varMax);
		drawCursor(ctx, posLimitMax, varMax, LIMIT_MAX_CURSOR_COLOR);
		
		// -----------------------------------------
		// Var position
		// -----------------------------------------	
		var posVarVal = (parentWidth / 100) * (100 - MARGE_CURSOR);
		drawCursor(ctx, posVarVal, varVal, POSITION_CURSOR_COLOR, 'POSITION');
		
	} else{
		// -----------------------------------------
		// Limite min
		// -----------------------------------------
		var posLimitMin = (parentWidth / 100) * MARGE_CURSOR;
		drawCursor(ctx, posLimitMin, varMin, LIMIT_MIN_CURSOR_COLOR);
		
		// -----------------------------------------
		// Limite max
		// -----------------------------------------
		var posLimitMax = (parentWidth / 100) * (100 - MARGE_CURSOR);
		drawCursor(ctx, posLimitMax, varMax, LIMIT_MAX_CURSOR_COLOR);
		
		// -----------------------------------------
		// Var position
		// -----------------------------------------	
		var posVarVal = getPosition(parentWidth, varMin, varMax, varVal);		
		drawCursor(ctx, posVarVal, varVal, POSITION_CURSOR_COLOR, 'POSITION');
	}
	
	//console.log( "End Draw!" );	
}

function getPosition(aWidth, aMinVal, aMaxVal, aPositionVal){
	var marge = (aWidth / 100) * MARGE_CURSOR;	
	var diffVal = Math.abs(aMinVal - aMaxVal);	
	var currentVal =  Math.abs(aMinVal - aPositionVal);	
	var posPercent = (currentVal / diffVal) * 100;
	var resultPosition = ((aWidth / 100) * posPercent) - marge;		
	return resultPosition;
}

function drawCursor(aContext, aPosition, aValue, aColor, aType){
	aContext.fillStyle = aColor;
	var xPos;
	var yPos;
	var cursorHeight;
	var cursorWidth;
	if(aType == 'POSITION'){
		xPos = aPosition + 1;
		cursorWidth = 3;
		yPos = MARGIN_TOP - 5;
		cursorHeight = GAUGE_HEIGHT + 5;
	}else{
		xPos = aPosition;
		cursorWidth = CURSOR_WIDTH;
		yPos = MARGIN_TOP;
		cursorHeight = GAUGE_HEIGHT;
	}
	
	aContext.fillRect(xPos, yPos, cursorWidth, cursorHeight);
	// Label
	var displayVarMaxVal = aValue+"%";
	drawLabel(aContext, displayVarMaxVal, aPosition);
}

function drawSimpleGauge(aContext, aParentWidth){
	// -----------------------------------------
	// Remplissage gauge
	// -----------------------------------------
	aContext.fillStyle = GAUGE_COLOR;
	//X, Y, W, H
	aContext.fillRect(0, MARGIN_TOP, aParentWidth, GAUGE_HEIGHT);
	
	// -----------------------------------------
	// Bordure gauge
	// -----------------------------------------
	aContext.lineWidth="1";
	aContext.strokeStyle=GAUGE_BORDER_COLOR;
	aContext.rect(0, MARGIN_TOP, aParentWidth, GAUGE_HEIGHT);
	aContext.stroke(); 
}

function drawLabel(aContext, aLabel, aPosition){
	aContext.fillStyle = LABEL_COLOR;
	aContext.font=LABEL_FONT;
	var txtW = aContext.measureText(aLabel).width;
	aContext.fillText(aLabel, aPosition - (txtW / 2), GAUGE_HEIGHT + 20);
}

