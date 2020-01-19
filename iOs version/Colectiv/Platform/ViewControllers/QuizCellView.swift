//
//  QuizCellView.swift
//  Colectiv
//
//  Created by Andrei Lobont on 14/01/2020.
//  Copyright © 2020 Andrei Lobont. All rights reserved.
//

import UIKit

class QuizCellView: UICollectionViewCell {
    @IBOutlet weak var quizImageView: UIImageView!
    @IBOutlet weak var quizTitleLabel: UILabel!
    @IBOutlet weak var quizTitleView: UIView!
    
    override func awakeFromNib() {
        super.awakeFromNib()
        
        quizTitleView.layer.cornerRadius = quizTitleView.frame.width / 8
    }
    
    func setCell(with quizTitle: String, and quizImageName: String) {
        quizTitleLabel.text = quizTitle
        quizImageView.image = UIImage(named: quizImageName)
    }
}
