/*
 * Copyright (C) 2013,2014 Samuel Audet
 *
 * This file is part of JavaCPP.
 *
 * JavaCPP is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 2 of the License, or
 * (at your option) any later version (subject to the "Classpath" exception
 * as provided in the LICENSE.txt file that accompanied this code).
 *
 * JavaCPP is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with JavaCPP.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.googlecode.javacpp.presets;

import com.googlecode.javacpp.Parser;
import com.googlecode.javacpp.annotation.Platform;
import com.googlecode.javacpp.annotation.Properties;

/**
 *
 * @author Samuel Audet
 */
@Properties(inherit=opencv_core.class, value={
    @Platform(include={"<opencv2/imgproc/types_c.h>", "<opencv2/imgproc/imgproc_c.h>", "<opencv2/imgproc/imgproc.hpp>"}, link="opencv_imgproc@.2.4"),
    @Platform(value="windows", link="opencv_imgproc248") },
        target="com.googlecode.javacpp.opencv_imgproc", helper="com.googlecode.javacpp.helper.opencv_imgproc")
public class opencv_imgproc implements Parser.InfoMapper {
    public void map(Parser.InfoMap infoMap) {
        infoMap.put(new Parser.Info("CvMoments").base("AbstractCvMoments"))
               .put(new Parser.Info("cvCalcBackProject").cppTypes("void", "IplImage**", "CvArr*", "CvHistogram*"))
               .put(new Parser.Info("cvCalcBackProjectPatch").cppTypes("void", "IplImage**", "CvArr*", "CvSize", "CvHistogram*", "int", "double"))
               .put(new Parser.Info("cv::Vec4f", "cv::Vec6f").cast(true).pointerTypes("FloatPointer"));
    }
}
