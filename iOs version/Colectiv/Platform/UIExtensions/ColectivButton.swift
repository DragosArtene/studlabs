//
//  ColectivButton.swift
//  Colectiv
//
//  Created by Lobont Andrei on 18/01/2020.
//  Copyright © 2020 Andrei Lobont. All rights reserved.
//

import UIKit

class ColectivButton: UIButton {
    override var isEnabled: Bool {
        didSet {
            backgroundColor = self.isEnabled ? UIColor(color: .buttonColor) : .lightGray
        }
    }
    
    override init(frame: CGRect) {
        super.init(frame: frame)
        
        setup()
    }
    
    required init?(coder: NSCoder) {
        super.init(coder: coder)
    }
    
    
    override func awakeFromNib() {
        super.awakeFromNib()
        
        setup()
    }
    
    private func setup() {
        labelSetup()
        styleSetup()
    }
    
    private func labelSetup() {
        setTitleColor(.white, for: .normal)
        titleLabel?.textColor = .white
        titleLabel?.font = UIFont(name: "Helvetica", size: 15)
        titleLabel?.textAlignment = .center
    }
    
    private func styleSetup() {
        backgroundColor = Color.buttonColor.uiColor
        roundCorners()
    }
    
    private func roundCorners() {
        layer.cornerRadius = 12
        layer.masksToBounds = true
    }
}
