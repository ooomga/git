;(function(window, ht) {
	/**
	 * 计算向量长度
	 * @param p [{ x: number, y: number }] 向量
	 */
	var distance = function(p1, p2) {
		if (!p2)
			return Math.sqrt(Math.pow(p1.x, 2) + Math.pow(p1.y, 2));
		return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
	};

	/**
	 * 获取向量上的固定距离的一点
	 * @param p0  [{ x: number, y: number }] 其实坐标
	 * @param p   [{ x: number, y: number }] 单位向量
	 * @param gap [number]                   距离
	 * @return    [{ x: number, y: number }] 点坐标
	 */
	var getPoint = function(p0, p, gap) {
		if (gap < 0) {
			p.x *= -1; 
			p.y *= -1;
		}

		gap = Math.abs(gap);
		return {
			x: p0.x + gap * p.x,
			y: p0.y + gap * p.y
		};
	};

	/** 
	 * 获取向量
	 * @param p0 [{ x: number, y: number }] 起点
	 * @param p1 [{ x: number, y: number }] 终点
	 * @param v  [ boolean ]                是否是垂直向量
	 * @return   [{ x: number, y: number }] 单位向量
	 */
	var getVector = function(p0, p1, v) {
		var p = { x: p1.x - p0.x, y: p1.y - p0.y },
			dis = distance(p);
		p.x /= dis;
		p.y /= dis;
		return v ? { x: p.y, y: -p.x } : p;
	};

	/**
	 * 线条点信息转换
	 * @param obj [{ points: ht.List, segments: ht.List }] 线条点信息
	 * @param gap [number]                                 距离线条的距离
	 * @return    [{ points: ht.List, segments: ht.List }] 线条点信息
	 */
	var getPointsInfo = function(obj, gap) {
		var ps = obj.points,
			ss = obj.segments;

		var sLen = ss.size(),
			s, preS, p0, p1, p2, p3, i, j, 
			ps0, ps1, psDis, dis,
			nPs = new ht.List(),
			nSs = ss.toList();
		for (i = 0, j = 0; i < sLen; i++) {
			s = ss.get(i);
			if (s === 2||preS === 1) {
				p0 = ps.get(j++);
				p1 = ps.get(j++);
				nPs.set(j - 2, getPoint(p0, getVector(p0, p1, true), gap));
			}
			else if (s === 3) {
				if (preS === 2) 
					nPs.set(j - 1, getPoint(p1, getVector(p1, p0, true), -gap));
				j += 1;
			}
			else if (s === 4) {
				if (preS === 2) 
					nPs.set(j - 1, getPoint(p1, getVector(p1, p0, true), -gap));
				j += 2;
			}
			preS = s;
		}

		var psSize = ps.size();
		p0 = ps.get(psSize - 2);
		p1 = ps.get(psSize - 1);
		nPs.set(psSize - 1, getPoint(p1, getVector(p1, p0, true), -gap));

		for (i = 0, j = 0; i < sLen; i++) {
			s = ss.get(i);
			if (s === 1 || s === 2) {
				p0 = ps.get(j++);
			}
			else if (s === 3) {
				ps0 = nPs.get(j - 1);
				p1 = ps.get(j++);
				p2 = ps.get(j++);
				ps1 = nPs.get(j - 1);
				
				dis = distance(p0, p2);
				psDis = distance(ps0, ps1);
				nPs.set(j - 2, getPoint(ps0, getVector(p0, p1), psDis / dis * distance(p0, p1)));

				p0 = p2;
			}
			else if (s === 4) {
				ps0 = nPs.get(j - 1);
				p1 = ps.get(j++);
				p2 = ps.get(j++);
				p3 = ps.get(j++);
				ps1 = nPs.get(j - 1);

				dis = distance(p0, p3);
				psDis = distance(ps0, ps1);
				nPs.set(j - 3, getPoint(ps0, getVector(p0, p1), psDis / dis * distance(p0, p1)));
				nPs.set(j - 2, getPoint(ps1, getVector(p3, p2), psDis / dis * distance(p3, p2)));

				p0 = p3;
			}
		}

		return { points: nPs, segments: nSs };
	};

	ht.Default.getPointsInfo = getPointsInfo;
}(window, ht));