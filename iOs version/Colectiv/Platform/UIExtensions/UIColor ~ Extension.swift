//
//  UIColor ~ Extension.swift
//  Colectiv
//
//  Created by Lobont Andrei on 18/01/2020.
//  Copyright © 2020 Andrei Lobont. All rights reserved.
//

import UIKit

enum Color {
    case colorPrimary, colorDark, colorAccent, brownGray, white, buttonColor
    
    var rgba: (CGFloat, CGFloat, CGFloat, CGFloat) {
        switch self {
        case .colorPrimary:
            return (36, 59, 85, 100)
        case .colorDark:
            return (20, 30, 48, 100)
        case .colorAccent:
            return (0, 78, 146, 100)
        case .brownGray:
            return (140, 140, 140, 100)
        case .white:
            return (255, 255, 255, 100)
        case .buttonColor:
            return (20, 40, 84, 100)
        }
    }
    
    var uiColor: UIColor {
        return UIColor(color: self)
    }
    
    var cgColor:CGColor {
        return UIColor(color: self).cgColor
    }
}

extension UIColor {
    convenience init(color: Color) {
        self.init(rgba: color.rgba)
    }
    
    convenience init(rgba: (red: CGFloat, green: CGFloat, blue: CGFloat, alpha: CGFloat)) {
        self.init(red: rgba.red / 255.0, green: rgba.green / 255.0, blue: rgba.blue / 255.0, alpha: rgba.alpha)
    }
}

