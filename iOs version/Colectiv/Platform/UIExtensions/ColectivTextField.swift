//
//  ColectivTextField.swift
//  Colectiv
//
//  Created by Lobont Andrei on 18/01/2020.
//  Copyright © 2020 Andrei Lobont. All rights reserved.
//

import UIKit

class ColectivTextField: UITextField {
    
    override func awakeFromNib() {
        setTextField()
    }
    
    private func setTextField() {
        self.attributedPlaceholder = NSAttributedString(string: self.placeholder ?? "",
        attributes: [NSAttributedString.Key.foregroundColor: UIColor.white])
        self.backgroundColor = Color.colorPrimary.uiColor
        self.layer.cornerRadius = self.frame.width / 2
    }
}
