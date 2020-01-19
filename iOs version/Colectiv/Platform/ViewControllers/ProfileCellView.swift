//
//  ProfileCellView.swift
//  Colectiv
//
//  Created by Lobont Andrei on 18/01/2020.
//  Copyright © 2020 Andrei Lobont. All rights reserved.
//

import UIKit

class ProfileCellView: UICollectionViewCell {
    @IBOutlet weak var quizTitleLabel: UILabel!
    
    override func awakeFromNib() {
        super.awakeFromNib()
        
    }
    
    func setQuiz(title: String) {
        quizTitleLabel.text = title
    }
}
