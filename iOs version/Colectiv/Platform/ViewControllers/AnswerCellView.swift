//
//  AnswerCellView.swift
//  Colectiv
//
//  Created by Andrei Lobont on 17/01/2020.
//  Copyright © 2020 Andrei Lobont. All rights reserved.
//

import UIKit

class AnswerCellView: UITableViewCell {
    @IBOutlet weak var answerLabel: UILabel!
    @IBOutlet weak var answerCheckImageView: UIImageView!
    
    override func awakeFromNib() {
        super.awakeFromNib()
        
        setImageBorder()
        answerCheckImageView.image = nil
    }
    
    func set(answer: String) {
        answerLabel.text = answer
    }
    
    func setSelectedAnswer() {
        answerCheckImageView.image = UIImage(named: "check")
    }
    
    private func setImageBorder() {
        answerCheckImageView.layer.borderWidth = 1
//        answerCheckImageView.layer.borderColor = (UIColor(red: 20 / 255, green: 40 / 255, blue: 84 / 255, alpha: 1) as! CGColor)
    }
}
