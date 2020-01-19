//
//  QuizCompletionViewController.swift
//  Colectiv
//
//  Created by Lobont Andrei on 17/01/2020.
//  Copyright © 2020 Andrei Lobont. All rights reserved.
//

import UIKit

class QuizCompletionViewController: UIViewController {
    var presenter: QuizCompletionPresenter?
    
    @IBOutlet weak var scoreLabel: UILabel!
    @IBOutlet weak var navigationButton: UIButton!
    @IBAction func navigationButtonAction(_ sender: Any) {
        presenter?.navigationButtonPressed()
    }
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        presenter?.viewDidLoad()
        
        self.navigationController?.navigationBar.isHidden = true
    }
}

extension QuizCompletionViewController: QuizCompletionView {
    func displayCorrectAnswers(answers: Int) {
        scoreLabel.text = "You scored \(answers) correct answers in this quiz. Well done!"
    }
}

extension QuizCompletionViewController: QuizCompletionNavigation {
    func navigateToQuiz() {
        guard let viewController = UIStoryboard(name: "Home", bundle: nil).instantiateViewController(identifier: "Home") as? HomeViewController else { return }
        self.navigationController?.pushViewController(viewController, animated: true)
    }
}
