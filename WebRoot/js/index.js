/**
 * 
 */
var ds = Math.round((Math.random() * 10));
var r = 0;
var g = 255;
var b = 0;

if (ds < 4) {
	r = 255;
	g = 0;
	b = 0;
} else if (ds > 7) {
	r = 0;
	g = 255;
	b = 0;
} else {
	r = 0;
	g = 0;
	b = 255;
}

var p = 0;
function cc() {
	if (r >= 255 && g <= 0 && b <= 0) {
		p = 1;
	}
	if (b >= 255 && g == 0 && b >= 255) {
		p = 2;
	}
	if (r <= 0 && b >= 255 && g <= 0) {
		p = 3;
	}
	if (r <= 0 && g >= 255 && b >= 255) {
		p = 4;
	}
	if (g >= 255 && b <= 0 && r <= 0) {
		p = 5;
	}
	if (r >= 255 && b == 0 && g >= 255) {
		p = 6;
	}
	switch (p) {
	case 1:
		b++;
		r = 255;
		g = 0;
		break;
	case 2:
		r--;
		g = 0;
		b = 255;
		break;
	case 3:
		g++;
		r = 0;
		b = 255;
		break;
	case 4:
		b--;
		r = 0;
		g = 255;
		break;
	case 5:
		r++;
		g = 255;
		b = 0;
		break;
	case 6:
		r = 255;
		g--;
		b = 0;
		break;
	}

	document.bgColor = '#' + trc(r) + trc(g) + trc(b);
}
function trc(b) {
	if (b.toString(16).length == 1) {
		return '00';
	} else {
		return b.toString(16)
	}

}
setInterval('cc()', 20);