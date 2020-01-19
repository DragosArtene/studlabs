//
//  QuestionViewController.swift
//  Colectiv
//
//  Created by Andrei Lobont on 17/01/2020.
//  Copyright © 2020 Andrei Lobont. All rights reserved.
//

import UIKit

class QuestionViewController: UIViewController {
    var presenter: QuestionPresenter?
    
    @IBOutlet weak var questionLabel: UILabel!
    @IBOutlet weak var tableView: UITableView!
    @IBOutlet weak var continueButton: UIButton!
    @IBAction func continueButtonAction(_ sender: Any) {
        let index = tableView.indexPathForSelectedRow?.row
        presenter?.continueButtonPressed(with: index!)
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        presenter?.viewDidLoad()
        
        continueButton.isHidden = true
        tableView.tableFooterView = UIView()
    }
}

extension QuestionViewController: UITableViewDataSource {
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return presenter?.getNumberOfAnswers() ?? 0
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        guard let cell = tableView.dequeueReusableCell(withIdentifier: "Answer") as? AnswerCellView else {
            return UITableViewCell()
        }
        let currentAnswer = presenter?.getCurrentAnswer(at: indexPath.row)
        cell.set(answer: currentAnswer!.answer)
        return cell
    }
    
    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        continueButton.isHidden = false
        let cells = self.tableView.visibleCells as! [AnswerCellView]
        var count = 0
        for cell in cells {
            if count == indexPath.row {
                cell.setSelectedAnswer()
            } else {
                cell.answerCheckImageView.image = nil
            }
            count += 1
        }
    }
}

extension QuestionViewController: UITableViewDelegate {
    
}

extension QuestionViewController: QuestionView {
    func displayQuestion(question: String) {
        questionLabel.text = question
    }
    
    func reloadData() {
        continueButton.isHidden = true
        tableView.reloadData()
        let cells = self.tableView.visibleCells as! [AnswerCellView]
        for cell in cells {
            cell.answerCheckImageView.image = nil
        }
    }
}

extension QuestionViewController: QuestionNavigation {
    func navigateToEndOfQuiz(with correctAnswers: Int, and quiz: Quiz) {
        guard let viewController = UIStoryboard(name: "Quiz", bundle: nil).instantiateViewController(identifier: "QuizCompletion") as? QuizCompletionViewController else { return }
        let presenter: QuizCompletionPresenter = QuizCompletionPresenter(view: viewController, navigation: viewController, correctAnswers: correctAnswers, quiz: quiz)
        viewController.presenter = presenter
        self.navigationController?.pushViewController(viewController, animated: true)
    }
}
